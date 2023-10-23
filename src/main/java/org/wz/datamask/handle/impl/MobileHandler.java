package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.MaskedType;
import org.wz.datamask.handle.AbstractMaskedHandler;
import org.wz.datamask.util.StringUtil;

/**
 * 保留前三后四，中间4位用****展示
 */
public class MobileHandler extends AbstractMaskedHandler {

    @Override
    public String doMask(String mobile) {
        return StringUtil.isBlank(mobile) ? "" : StringUtil.hide(mobile, 3, mobile.length() - 4);
    }

    @Override
    public String getFieldType() {
        return MaskedType.MOBILE_PHONE.name();
    }

}
