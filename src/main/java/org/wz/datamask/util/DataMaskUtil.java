package org.wz.datamask.util;

import org.reflections.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.wz.datamask.annotation.Masked;
import org.wz.datamask.annotation.MaskedField;
import org.wz.datamask.handle.DataMaskHandlerSelector;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class DataMaskUtil {

    private DataMaskHandlerSelector dataMaskHandlerSelector;

    @Autowired
    public DataMaskUtil(DataMaskHandlerSelector dataMaskHandlerSelector) {
        this.dataMaskHandlerSelector = dataMaskHandlerSelector;
    }

    public void convert(Object data) {
        if(data == null) {
            return;
        }
        if(data instanceof Collection){
            Collection collection = (Collection) data;
            if(!CollectionUtils.isEmpty(collection)){
                for (Object item : collection) {
                    convert(item);
                }
            }
        }else if(data instanceof Map){
            Map map = (Map) data;
            if(!CollectionUtils.isEmpty(map)){
                for (Object key : map.keySet()) {
                    convert(map.get(key));
                }
            }
        }else{
            convertObject(data);
        }
    }

    private void convertObject(Object data) {
        Class<?> dataClass = data.getClass();

        Set<Field> maskedFieldSet = ReflectionUtils.getFields(dataClass, ReflectionUtils.withAnnotation(MaskedField.class));
        if (!CollectionUtils.isEmpty(maskedFieldSet)) {
            for (Field field:maskedFieldSet) {
                org.springframework.util.ReflectionUtils.makeAccessible(field);
                Object value = org.springframework.util.ReflectionUtils.getField(field, data);
                org.springframework.util.ReflectionUtils.setField(field, data, doMask(value, field.getAnnotation(MaskedField.class)));
            }
        }

        Set<Field> maskedSet = ReflectionUtils.getFields(dataClass, ReflectionUtils.withAnnotation(Masked.class));
        if (!CollectionUtils.isEmpty(maskedSet)) {
            for (Field field:maskedSet) {
                org.springframework.util.ReflectionUtils.makeAccessible(field);
                Object value = org.springframework.util.ReflectionUtils.getField(field, data);
                convert(value);
            }
        }
    }

    private Object doMask(Object value, MaskedField maskedField) {
        if (value != null && maskedField != null && value instanceof String && StringUtils.hasText((String) value)) {
            return dataMaskHandlerSelector.doMask(maskedField.value().name(), maskedField.id(), value);
        }
        return value;
    }

}
