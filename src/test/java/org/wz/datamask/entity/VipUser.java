package org.wz.datamask.entity;

import org.wz.datamask.annotation.MaskedField;
import org.wz.datamask.enums.MaskedType;

public class VipUser extends User {

    @MaskedField(value = MaskedType.ADDRESS)
    private String address;

    @MaskedField(value = MaskedType.ID_CARD)
    private String idCard;

    public VipUser(String name, String mobile, String address, String idCard) {
        super(name, mobile);
        this.address = address;
        this.idCard = idCard;
    }

    public VipUser(String name, String mobile) {
        super(name, mobile);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "VipUser{" +
                "address='" + address + '\'' +
                ", idCard=" + idCard +
                '}';
    }
}
