package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.FieldType;
import org.wz.datamask.handle.DataMaskHandlerAdapter;
import org.wz.datamask.util.StringUtil;

/**
 * Address详细地址仅保留前5个明文，剩余*脱敏
 */
public class AddressHandler extends DataMaskHandlerAdapter {

    @Override
    public String doMask(String address) {
        if (StringUtil.isBlank(address)) {
            return "";
        }
        int length = address.length();
        if (length <= 5) {
            return address;
        } else {
            return StringUtil.hide(address, 5, length);
        }
    }

    @Override
    public String getFieldType() {
        return FieldType.ADDRESS.name();
    }
}
