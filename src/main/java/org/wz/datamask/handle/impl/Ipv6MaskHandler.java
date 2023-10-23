package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.MaskedType;
import org.wz.datamask.handle.AbstractMaskHandler;
import org.wz.datamask.util.StringUtil;

/**
 * Ipv6 Mask
 */
public class Ipv6MaskHandler extends AbstractMaskHandler {

    @Override
    public String doMask(String ipv6) {
        return StringUtil.subBefore(ipv6, ':', false) + ":*:*:*:*:*:*:*";
    }

    @Override
    public String getFieldType() {
        return MaskedType.IPV6.name();
    }

}
