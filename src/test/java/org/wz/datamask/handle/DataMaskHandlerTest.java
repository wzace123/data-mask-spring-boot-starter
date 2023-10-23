package org.wz.datamask.handle;

import org.junit.Assert;
import org.junit.Test;
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

public class DataMaskHandlerTest {

    @Test
    public void addressMaskHandlerTest() {
        String maskResult = new AddressMaskHandler().doMask("湖北省武汉市黄鹤楼一栋101");
        Assert.assertEquals("湖北省武汉*********", maskResult);
    }

    @Test
    public void bankCardMaskHandlerTest() {
        String maskResult = new BankCardMaskHandler().doMask("6845987565214587");
        Assert.assertEquals("6845********4587", maskResult);
    }

    @Test
    public void carLicenseMaskHandlerTest() {
        String maskResult = new CarLicenseMaskHandler().doMask("京AD88888");
        Assert.assertEquals("京AD****8", maskResult);
    }

    @Test
    public void emailMaskHandlerTest() {
        String maskResult = new EmailMaskHandler().doMask("testab@Gmail.com");
        Assert.assertEquals("t*****@Gmail.com", maskResult);
    }

    @Test
    public void fixedPhoneMaskHandlerTest() {
        String maskResult = new FixedPhoneMaskHandler().doMask("81818989");
        Assert.assertEquals("8181**89", maskResult);
    }

    @Test
    public void idCardNumMaskHandlerTest() {
        String maskResult = new IdCardNumMaskHandler().doMask("426587966548523658");
        Assert.assertEquals("4****************8", maskResult);
    }

    @Test
    public void ipv4MaskHandlerTest() {
        String maskResult = new Ipv4MaskHandler().doMask("192.169.31.12");
        Assert.assertEquals("192.*.*.*", maskResult);
    }

    @Test
    public void ipv6MaskHandlerTest() {
        String maskResult = new Ipv6MaskHandler().doMask("2001:470:c:1818::2");
        Assert.assertEquals("2001:*:*:*:*:*:*:*", maskResult);
    }

    @Test
    public void mobilePhoneMaskHandlerTest() {
        String maskResult = new MobilePhoneMaskHandler().doMask("18879546582");
        Assert.assertEquals("188****6582", maskResult);
    }

    @Test
    public void passwordMaskHandlerTest() {
        String maskResult = new PasswordMaskHandler().doMask("Wlsfk#$123");
        Assert.assertEquals("**********", maskResult);
    }

    @Test
    public void userNameMaskHandlerTest() {
        String maskResult = new UserNameMaskHandler().doMask("李大刀");
        Assert.assertEquals("李**", maskResult);
    }

}
