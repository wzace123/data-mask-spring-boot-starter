package org.wz.datamask.util;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;
import org.wz.datamask.annotation.Masked;
import org.wz.datamask.entity.VipUser;

public class ObjectUtilTest {

    @Masked(value = "name")
    @Test
    public void getMaskedValueTest() {
        VipUser user = new VipUser("mick", "18827011451", "湖北省武汉市黄鹤楼一栋101", "4321453123435667");
        Masked masked = ReflectionUtils.findMethod(ObjectUtilTest.class, "getMaskedValueTest").getAnnotation(Masked.class);
        Object obj = ObjectUtil.getValue(user, masked);
        Assert.assertEquals("mick", obj);
    }

    /**
     * Method will be execution exception. because this Filed errorName is not exists in class
     */
    @Masked(value = "errorName")
    @Test
    public void getMaskedValueErrorTest() {
        try {
            VipUser user = new VipUser("mick", "18827011451", "湖北省武汉市黄鹤楼一栋101", "4321453123435667");
            Masked masked = ReflectionUtils.findMethod(ObjectUtilTest.class, "getMaskedValueErrorTest").getAnnotation(Masked.class);
            Object obj = ObjectUtil.getValue(user, masked);
            Assert.assertEquals("mick", obj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getValueTest() {
        VipUser user = new VipUser("mick", "18827011451", "湖北省武汉市黄鹤楼一栋101", "4321453123435667");
        Object obj = ObjectUtil.getValue(user, "name");
        Assert.assertEquals("mick", obj);
    }

}
