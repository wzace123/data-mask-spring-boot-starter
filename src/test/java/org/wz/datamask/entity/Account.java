package org.wz.datamask.entity;

import org.wz.datamask.annotation.MaskedField;
import org.wz.datamask.enums.MaskedType;

import java.io.Serializable;

public class Account implements Serializable {
    @MaskedField(value = MaskedType.USER_NAME)
    private String name;
    @MaskedField(value = MaskedType.ID_CARD)
    private String idCard;
    @MaskedField(value = MaskedType.FIXED_PHONE)
    private String fixedPhone;
    @MaskedField(value = MaskedType.MOBILE_PHONE)
    private String mobilePhone;
    @MaskedField(value = MaskedType.ADDRESS)
    private String address;
    @MaskedField(value = MaskedType.EMAIL)
    private String email;
    @MaskedField(value = MaskedType.PASSWORD)
    private String password;
    @MaskedField(value = MaskedType.CAR_LICENSE)
    private String carLicense;
    @MaskedField(value = MaskedType.BANK_CARD)
    private String bankCard;
    @MaskedField(value = MaskedType.IPV4)
    private String ipv4;
    @MaskedField(value = MaskedType.IPV6)
    private String ipv6;

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
