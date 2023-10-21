package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.FieldType;
import org.wz.datamask.handle.DataMaskHandlerAdapter;
import org.wz.datamask.util.StringUtil;

/**
 * 只显示首字母
 */
public class UserNameHandler extends DataMaskHandlerAdapter {

    @Override
    public String doMask(String name) {
        return StringUtil.isBlank(name) ? "" : StringUtil.hide(name, 1, name.length());
    }

    @Override
    public String getFieldType() {
        return FieldType.USER_NAME.name();
    }
}
