package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.MaskedType;
import org.wz.datamask.handle.AbstractMaskedHandler;
import org.wz.datamask.util.StringUtil;

/**
 * 只显示首字母
 */
public class UserNameHandler extends AbstractMaskedHandler {

    @Override
    public String doMask(String name) {
        return StringUtil.isBlank(name) ? "" : StringUtil.hide(name, 1, name.length());
    }

    @Override
    public String getFieldType() {
        return MaskedType.CHINESE_NAME.name();
    }
}
