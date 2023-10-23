package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.MaskedType;
import org.wz.datamask.handle.AbstractMaskHandler;
import org.wz.datamask.util.StringUtil;

/**
 * password mask
 */
public class PasswordMaskHandler extends AbstractMaskHandler {

    @Override
    public String doMask(String password) {
        return StringUtil.isBlank(password) ? "" : StringUtil.repeat('*', password.length());
    }

    @Override
    public String getFieldType() {
        return MaskedType.PASSWORD.name();
    }
}
