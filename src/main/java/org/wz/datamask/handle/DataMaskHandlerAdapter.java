package org.wz.datamask.handle;


/**
 * 屏蔽敏感字段处理器
 */
public class DataMaskHandlerAdapter implements DataMaskHandler {

    @Override
    public String doMask(String fieldValue) {
        throw new RuntimeException();
    }

    @Override
    public String getFieldType() {
        throw new RuntimeException();
    }

    @Override
    public String getId() {
        return "";
    }
}
