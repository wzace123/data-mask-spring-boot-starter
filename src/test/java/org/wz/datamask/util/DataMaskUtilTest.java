package org.wz.datamask.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wz.datamask.entity.User;
import org.wz.datamask.enums.FieldType;
import org.wz.datamask.handle.DataMaskHandler;
import org.wz.datamask.handle.DataMaskHandlerSelector;
import org.wz.datamask.handle.impl.AddressHandler;
import org.wz.datamask.handle.impl.IdCardNumHandler;
import org.wz.datamask.handle.impl.MobileHandler;
import org.wz.datamask.handle.impl.UserNameHandler;

import java.util.HashMap;
import java.util.Map;

public class DataMaskUtilTest {

    private DataMaskUtil dataMaskUtil;

    private User user;

    @Before
    public void init() {

        DataMaskHandlerSelector selector = new DataMaskHandlerSelector();

        Map<String, DataMaskHandler> serviceMap = new HashMap<>();
        serviceMap.put("_" + FieldType.USER_NAME.name(), new UserNameHandler());
        serviceMap.put("_" + FieldType.ID_CARD.name(), new IdCardNumHandler());
        serviceMap.put("_" + FieldType.MOBILE.name(), new MobileHandler());
        serviceMap.put("_" + FieldType.ADDRESS.name(), new AddressHandler());
        selector.setServiceMap(serviceMap);
        dataMaskUtil = new DataMaskUtil(selector);
        user = new User("mick", "18827011451");
    }

    @Test
    public void userConvertTest() {
        dataMaskUtil.convert(user);
        Assert.assertEquals(user.getMobile(), "188****1451");
        Assert.assertEquals(user.getName(), "m***");
    }

}
