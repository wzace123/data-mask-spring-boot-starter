package org.wz.datamask.handle.impl;

import org.wz.datamask.constant.FieldType;
import org.wz.datamask.handle.AbstractMaskHandler;
import org.wz.datamask.util.StringUtil;

/**
 * Address mask
 */
public class AddressMaskHandler extends AbstractMaskHandler {

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
        return FieldType.ADDRESS;
    }
}
