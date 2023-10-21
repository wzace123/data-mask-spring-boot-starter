package org.wz.datamask.handle;

/**
 * Data Masking Handler
 */
public interface DataMaskHandler {

    String doMask(String fieldValue);

    String getFieldType();

    String getId();
}
