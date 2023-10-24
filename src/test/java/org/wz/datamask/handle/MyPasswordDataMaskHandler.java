package org.wz.datamask.handle;

import org.wz.datamask.constant.FieldType;

public class MyPasswordDataMaskHandler implements DataMaskHandler {
    @Override
    public String doMask(String fieldValue) {
        return "MyPasswordMaskHandler";
    }

    @Override
    public String getFieldType() {
        return FieldType.PASSWORD;
    }

    @Override
    public String getId() {
        return "myId";
    }
}
