package org.wz.datamask.handle.impl;

import org.wz.datamask.constant.FieldType;
import org.wz.datamask.handle.AbstractMaskHandler;
import org.wz.datamask.util.StringUtil;

/**
 * Fixed Phone mask
 */
public class FixedPhoneMaskHandler extends AbstractMaskHandler {

    @Override
    public String doMask(String num) {
        return StringUtil.isBlank(num) ? "" : StringUtil.hide(num, 4, num.length() - 2);
    }

    @Override
    public String getFieldType() {
        return FieldType.FIXED_PHONE;
    }
}
