package org.wz.datamask.handle.impl;

import org.wz.datamask.constant.FieldType;
import org.wz.datamask.handle.AbstractMaskHandler;
import org.wz.datamask.util.StringUtil;

/**
 * Bank Card Mask
 */
public class BankCardMaskHandler extends AbstractMaskHandler {

    @Override
    public String doMask(String bankCardNo) {
        return StringUtil.isBlank(bankCardNo) ? "" : StringUtil.hide(bankCardNo, 4, bankCardNo.length() - 4);
    }

    @Override
    public String getFieldType() {
        return FieldType.BANK_CARD;
    }

}
