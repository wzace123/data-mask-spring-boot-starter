package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.FieldType;
import org.wz.datamask.handle.DataMaskAdapter;

/**
 * Address详细地址仅保留前5个明文，剩余*脱敏
 */
public class AddressHandler extends DataMaskAdapter {

    @Override
    public String doMask(String address) {
        if (isBlank(address)) {
            return "";
        }
        int length = address.length();
        if (length <= 5) {
            return address;
        } else {
            return hide(address, 5, length);
        }
    }

    @Override
    public String getFieldType() {
        return FieldType.ADDRESS.name();
    }
}
