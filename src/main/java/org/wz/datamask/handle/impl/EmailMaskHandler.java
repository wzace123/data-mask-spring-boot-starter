package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.MaskedType;
import org.wz.datamask.handle.AbstractMaskHandler;
import org.wz.datamask.util.StringUtil;

/**
 * Email Mask
 */
public class EmailMaskHandler extends AbstractMaskHandler {

    @Override
    public String doMask(String email) {
        if (StringUtil.isBlank(email)) {
            return "";
        } else {
            int index = StringUtil.indexOf(email, '@');
            return index <= 1 ? email : StringUtil.hide(email, 1, index);
        }
    }

    @Override
    public String getFieldType() {
        return MaskedType.EMAIL.name();
    }

}
