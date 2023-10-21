package org.wz.datamask.entity;

import org.wz.datamask.annotation.MaskedField;
import org.wz.datamask.enums.FieldType;

public class User {

    @MaskedField(value = FieldType.USER_NAME)
    private String name;

    @MaskedField(value = FieldType.MOBILE)
    private String mobile;

    public User(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
