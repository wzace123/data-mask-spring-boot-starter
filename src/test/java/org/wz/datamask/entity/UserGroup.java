package org.wz.datamask.entity;

import org.wz.datamask.annotation.Masked;

import java.io.Serializable;
import java.util.List;

public class UserGroup implements Serializable {

    @Masked
    private List<User> userList;

    public UserGroup(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
