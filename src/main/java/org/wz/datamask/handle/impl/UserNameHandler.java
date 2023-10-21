package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.FieldType;
import org.wz.datamask.handle.DataMaskAdapter;

/**
 * 只显示首字母
 */
public class UserNameHandler extends DataMaskAdapter {

    @Override
    public String doMask(String name) {
        return isBlank(name) ? "" : hide(name, 1, name.length());
    }

    @Override
    public String getFieldType() {
        return FieldType.USER_NAME.name();
    }
}
