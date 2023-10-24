package org.wz.datamask.entity;

import org.wz.datamask.annotation.MaskedField;
import org.wz.datamask.constant.FieldType;

import java.io.Serializable;

public class Account implements Serializable {
    @MaskedField(value = FieldType.USER_NAME)
    private String name;
    @MaskedField(value = FieldType.ID_CARD)
    private String idCard;
    @MaskedField(value = FieldType.FIXED_PHONE)
    private String fixedPhone;
    @MaskedField(value = FieldType.MOBILE_PHONE)
    private String mobilePhone;
    @MaskedField(value = FieldType.ADDRESS)
    private String address;
    @MaskedField(value = FieldType.EMAIL)
    private String email;
    @MaskedField(value = FieldType.PASSWORD)
    private String password;
    @MaskedField(value = FieldType.CAR_LICENSE)
    private String carLicense;
    @MaskedField(value = FieldType.BANK_CARD)
    private String bankCard;
    @MaskedField(value = FieldType.IPV4)
    private String ipv4;
    @MaskedField(value = FieldType.IPV6)
    private String ipv6;

    @MaskedField(value = FieldType.PASSWORD, id = "myId")
    private String myPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getFixedPhone() {
        return fixedPhone;
    }

    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public String getMyPassword() {
        return myPassword;
    }

    public void setMyPassword(String myPassword) {
        this.myPassword = myPassword;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", fixedPhone='" + fixedPhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", carLicense='" + carLicense + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", ipv4='" + ipv4 + '\'' +
                ", ipv6='" + ipv6 + '\'' +
                '}';
    }
}
