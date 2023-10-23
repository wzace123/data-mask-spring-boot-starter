package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.MaskedType;
import org.wz.datamask.handle.AbstractMaskHandler;
import org.wz.datamask.util.StringUtil;

/**
 * IdCard Num mask
 */
public class IdCardNumMaskHandler extends AbstractMaskHandler {

    @Override
    public String doMask(String idCardNum) {
        return StringUtil.maskStr(idCardNum,1,1);
    }

    @Override
    public String getFieldType() {
        return MaskedType.ID_CARD.name();
    }
    
}
