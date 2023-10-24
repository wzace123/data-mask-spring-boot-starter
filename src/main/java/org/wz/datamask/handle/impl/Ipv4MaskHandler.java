package org.wz.datamask.handle.impl;

import org.wz.datamask.constant.FieldType;
import org.wz.datamask.handle.AbstractMaskHandler;
import org.wz.datamask.util.StringUtil;

/**
 * Ipv4 Mask
 */
public class Ipv4MaskHandler extends AbstractMaskHandler {

    @Override
    public String doMask(String ipv4) {
        return StringUtil.subBefore(ipv4, '.', false) + ".*.*.*";
    }

    @Override
    public String getFieldType() {
        return FieldType.IPV4;
    }

}
