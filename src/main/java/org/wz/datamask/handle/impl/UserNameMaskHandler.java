package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.MaskedType;
import org.wz.datamask.handle.AbstractMaskHandler;
import org.wz.datamask.util.StringUtil;

/**
 * User Name mask
 */
public class UserNameMaskHandler extends AbstractMaskHandler {

    @Override
    public String doMask(String name) {
        return StringUtil.isBlank(name) ? "" : StringUtil.hide(name, 1, name.length());
    }

    @Override
    public String getFieldType() {
        return MaskedType.USER_NAME.name();
    }
}
