package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.FieldType;
import org.wz.datamask.handle.DataMaskAdapter;

/**
 * 保留前三后四，中间4位用****展示
 */
public class MobileHandler extends DataMaskAdapter {

    @Override
    public String doMask(String mobile) {
        return isBlank(mobile) ? "" : hide(mobile, 3, mobile.length() - 4);
    }

    @Override
    public String getFieldType() {
        return FieldType.MOBILE.name();
    }

}
