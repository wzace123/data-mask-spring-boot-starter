package org.wz.datamask.handle.impl;

import org.wz.datamask.enums.MaskedType;
import org.wz.datamask.handle.AbstractMaskHandler;
import org.wz.datamask.util.StringUtil;

/**
 * Car License Mask
 */
public class CarLicenseMaskHandler extends AbstractMaskHandler {

    @Override
    public String doMask(String carLicense) {
        if (StringUtil.isBlank(carLicense)) {
            return "";
        } else {
            if (carLicense.length() == 7) {
                carLicense = StringUtil.hide(carLicense, 3, 6);
            } else if (carLicense.length() == 8) {
                carLicense = StringUtil.hide(carLicense, 3, 7);
            }
            return carLicense;
        }
    }

    @Override
    public String getFieldType() {
        return MaskedType.CAR_LICENSE.name();
    }

}
