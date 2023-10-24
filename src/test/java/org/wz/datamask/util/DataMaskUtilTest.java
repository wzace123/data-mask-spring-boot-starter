package org.wz.datamask.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;
import org.wz.datamask.annotation.Masked;
import org.wz.datamask.constant.FieldType;
import org.wz.datamask.entity.Account;
import org.wz.datamask.entity.PageWrapper;
import org.wz.datamask.entity.ResultWrapper;
import org.wz.datamask.entity.User;
import org.wz.datamask.entity.UserGroup;
import org.wz.datamask.entity.UserGroupWrapper;
import org.wz.datamask.entity.VipUser;
import org.wz.datamask.handle.DataMaskHandler;
import org.wz.datamask.handle.DataMaskHandlerSelector;
import org.wz.datamask.handle.MyPasswordDataMaskHandler;
import org.wz.datamask.handle.impl.AddressMaskHandler;
import org.wz.datamask.handle.impl.BankCardMaskHandler;
import org.wz.datamask.handle.impl.CarLicenseMaskHandler;
import org.wz.datamask.handle.impl.EmailMaskHandler;
import org.wz.datamask.handle.impl.FixedPhoneMaskHandler;
import org.wz.datamask.handle.impl.IdCardNumMaskHandler;
import org.wz.datamask.handle.impl.Ipv4MaskHandler;
import org.wz.datamask.handle.impl.Ipv6MaskHandler;
import org.wz.datamask.handle.impl.MobilePhoneMaskHandler;
import org.wz.datamask.handle.impl.PasswordMaskHandler;
import org.wz.datamask.handle.impl.UserNameMaskHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataMaskUtilTest {

    private DataMaskUtil dataMaskUtil;

    @Before
    public void init() {
        DataMaskHandlerSelector selector = new DataMaskHandlerSelector();
        Map<String, DataMaskHandler> serviceMap = new HashMap<>();
        serviceMap.put("_" + FieldType.USER_NAME, new UserNameMaskHandler());
        serviceMap.put("_" + FieldType.ID_CARD, new IdCardNumMaskHandler());
        serviceMap.put("_" + FieldType.MOBILE_PHONE, new MobilePhoneMaskHandler());
        serviceMap.put("_" + FieldType.ADDRESS, new AddressMaskHandler());
        serviceMap.put("_" + FieldType.PASSWORD, new PasswordMaskHandler());
        serviceMap.put("_" + FieldType.IPV4, new Ipv4MaskHandler());
        serviceMap.put("_" + FieldType.IPV6, new Ipv6MaskHandler());
        serviceMap.put("_" + FieldType.CAR_LICENSE, new CarLicenseMaskHandler());
        serviceMap.put("_" + FieldType.BANK_CARD, new BankCardMaskHandler());
        serviceMap.put("_" + FieldType.FIXED_PHONE, new FixedPhoneMaskHandler());
        serviceMap.put("_" + FieldType.EMAIL, new EmailMaskHandler());
        serviceMap.put("myId_" + FieldType.PASSWORD, new MyPasswordDataMaskHandler());
        selector.setServiceMap(serviceMap);
        dataMaskUtil = new DataMaskUtil(selector);
    }

    @After
    public void cleanCache() {
        ClassFieldsLocalCache.clean();
    }

    @Test
    public void simpleObjectDataMaskTest() {
        User user = new User("mick", "18827011451");
        dataMaskUtil.convert(user);
        Assert.assertEquals("188****1451", user.getMobile());
        Assert.assertEquals("m***", user.getName());
    }

    @Test
    public void simpleObjectListDataMaskTest() {
        User user1 = new User("mick", "18827011451");
        User user2 = new User("sick", "18827011452");
        User user3 = new User("nick", "18827011453");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        dataMaskUtil.convert(userList);
        Assert.assertEquals("188****1451", user1.getMobile());
        Assert.assertEquals("m***", user1.getName());
        Assert.assertEquals("188****1452", user2.getMobile());
        Assert.assertEquals("s***", user2.getName());
        Assert.assertEquals("188****1453", user3.getMobile());
        Assert.assertEquals("n***", user3.getName());
    }

    @Test
    public void simpleObjectMapDataMaskTest() {
        User user1 = new User("mick", "18827011451");
        User user2 = new User("sick", "18827011452");
        User user3 = new User("nick", "18827011453");

        Map<String, User> map = new HashMap<>();
        map.put("user1", user1);
        map.put("user2", user2);
        map.put("user3", user3);

        dataMaskUtil.convert(map);
        Assert.assertEquals("188****1451", user1.getMobile());
        Assert.assertEquals("m***", user1.getName());
        Assert.assertEquals("188****1452", user2.getMobile());
        Assert.assertEquals("s***", user2.getName());
        Assert.assertEquals("188****1453", user3.getMobile());
        Assert.assertEquals("n***", user3.getName());
    }

    @Masked(value = "data")
    @Test
    public void simpleNestObjectDataMaskTest() {
        VipUser user = new VipUser("mick", "18827011451", "湖北省武汉市黄鹤楼一栋101", "4321453123435667");
        ResultWrapper wapper = new ResultWrapper(0, "this is message", user, true);
        Masked masked = ReflectionUtils.findMethod(DataMaskUtilTest.class, "simpleNestObjectDataMaskTest").getAnnotation(Masked.class);
        dataMaskUtil.convert(ObjectUtil.getValue(wapper, masked));
        Assert.assertEquals("188****1451", user.getMobile());
        Assert.assertEquals("m***", user.getName());
        Assert.assertEquals("湖北省武汉*********", user.getAddress());
        Assert.assertEquals("4**************7", user.getIdCard());
    }

    @Masked(value = "data.content")
    @Test
    public void multipleNestObjectDataMaskTest1() {
        VipUser user = new VipUser("mick", "18827011451", "湖北省武汉市黄鹤楼一栋101", "4321453123435667");
        VipUser user2 = new VipUser("nick", "18827011452", "湖北省武汉市黄鹤楼一栋102", "4321453123435668");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        PageWrapper pageWapper = new PageWrapper<User>(userList, userList.size());
        ResultWrapper wapper = new ResultWrapper(0, "this is message", pageWapper, true);
        Masked masked = ReflectionUtils.findMethod(DataMaskUtilTest.class, "multipleNestObjectDataMaskTest1").getAnnotation(Masked.class);
        dataMaskUtil.convert(ObjectUtil.getValue(wapper, masked));
        Assert.assertEquals("188****1451", user.getMobile());
        Assert.assertEquals("m***", user.getName());
        Assert.assertEquals("湖北省武汉*********", user.getAddress());
        Assert.assertEquals("4**************7", user.getIdCard());
        Assert.assertEquals("188****1452", user2.getMobile());
        Assert.assertEquals("n***", user2.getName());
        Assert.assertEquals("湖北省武汉*********", user2.getAddress());
        Assert.assertEquals("4**************8", user2.getIdCard());
    }

    @Test
    public void multipleNestObjectDataMaskTest2() {
        VipUser user = new VipUser("mick", "18827011451", "湖北省武汉市黄鹤楼一栋101", "4321453123435667");
        VipUser user2 = new VipUser("nick", "18827011452", "湖北省武汉市黄鹤楼一栋102", "4321453123435668");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        UserGroup userGroup = new UserGroup(userList);
        UserGroupWrapper wapper = new UserGroupWrapper(userGroup);
        Masked masked = ReflectionUtils.findMethod(DataMaskUtilTest.class, "multipleNestObjectDataMaskTest2").getAnnotation(Masked.class);
        dataMaskUtil.convert(ObjectUtil.getValue(wapper, masked));
        Assert.assertEquals("188****1451", user.getMobile());
        Assert.assertEquals("m***", user.getName());
        Assert.assertEquals("湖北省武汉*********", user.getAddress());
        Assert.assertEquals("4**************7", user.getIdCard());
        Assert.assertEquals("188****1452", user2.getMobile());
        Assert.assertEquals("n***", user2.getName());
        Assert.assertEquals("湖北省武汉*********", user2.getAddress());
        Assert.assertEquals("4**************8", user2.getIdCard());
    }

    @Test
    public void allMaskTypeTest() {
        Account account = new Account();
        account.setName("李大刀");
        account.setIdCard("426587966548523658");
        account.setFixedPhone("81818989");
        account.setMobilePhone("18879546582");
        account.setAddress("湖北省武汉市黄鹤楼一栋101");
        account.setEmail("testab@Gmail.com");
        account.setPassword("Wlsfk#$123");
        account.setCarLicense("京AD88888");
        account.setBankCard("6845987565214587");
        account.setIpv4("192.169.31.12");
        account.setIpv6("2001:470:c:1818::2");
        account.setMyPassword("test password");
        Masked masked = ReflectionUtils.findMethod(DataMaskUtilTest.class, "allMaskTypeTest").getAnnotation(Masked.class);
        dataMaskUtil.convert(ObjectUtil.getValue(account, masked));
        Assert.assertEquals("李**", account.getName());
        Assert.assertEquals("**********", account.getPassword());
        Assert.assertEquals("188****6582", account.getMobilePhone());
        Assert.assertEquals("2001:*:*:*:*:*:*:*", account.getIpv6());
        Assert.assertEquals("192.*.*.*", account.getIpv4());
        Assert.assertEquals("4****************8", account.getIdCard());
        Assert.assertEquals("8181**89", account.getFixedPhone());
        Assert.assertEquals("t*****@Gmail.com", account.getEmail());
        Assert.assertEquals("京AD****8", account.getCarLicense());
        Assert.assertEquals("6845********4587", account.getBankCard());
        Assert.assertEquals("湖北省武汉*********", account.getAddress());
        Assert.assertEquals("MyPasswordMaskHandler", account.getMyPassword());
    }

}
