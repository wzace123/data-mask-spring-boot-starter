package org.wz.datamask.handle.impl;

import org.wz.datamask.constant.FieldType;
import org.wz.datamask.handle.AbstractMaskHandler;
import org.wz.datamask.util.StringUtil;

/**
 * Mobile Phone mask
 */
public class MobilePhoneMaskHandler extends AbstractMaskHandler {

    @Override
    public String doMask(String mobile) {
        return StringUtil.isBlank(mobile) ? "" : StringUtil.hide(mobile, 3, mobile.length() - 4);
    }

    @Override
    public String getFieldType() {
        return FieldType.MOBILE_PHONE;
    }

}
