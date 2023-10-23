package org.wz.datamask.entity;

import org.wz.datamask.annotation.Masked;

import java.io.Serializable;

public class UserGroupWrapper implements Serializable {

    @Masked
    private UserGroup userGroup;

    public UserGroupWrapper(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }
}
