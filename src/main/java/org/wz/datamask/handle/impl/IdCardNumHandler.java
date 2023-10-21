package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.FieldType;
import org.wz.datamask.handle.DataMaskAdapter;

/**
 * 身份证号仅保留头尾各1明文数字
 */
public class IdCardNumHandler extends DataMaskAdapter {

    @Override
    public String doMask(String idCardNum) {
        return maskStr(idCardNum,1,1);
    }

    @Override
    public String getFieldType() {
        return FieldType.ID_CARD.name();
    }
    
}
