package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.FieldType;
import org.wz.datamask.handle.DataMaskHandlerAdapter;
import org.wz.datamask.util.StringUtil;

/**
 * 保留前三后四，中间4位用****展示
 */
public class MobileHandler extends DataMaskHandlerAdapter {

    @Override
    public String doMask(String mobile) {
        return StringUtil.isBlank(mobile) ? "" : StringUtil.hide(mobile, 3, mobile.length() - 4);
    }

    @Override
    public String getFieldType() {
        return FieldType.MOBILE.name();
    }

}
