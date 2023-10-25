package org.wz.datamask.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import org.wz.datamask.annotation.Masked;
import org.wz.datamask.annotation.MaskedField;
import org.wz.datamask.handle.DataMaskHandlerSelector;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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

        Set<Field> maskedFieldSet = ThreadLocalCache.getFields(dataClass, MaskedField.class);
        if (maskedFieldSet == null) {
            maskedFieldSet = getFields(dataClass, MaskedField.class);
            maskedFieldSet = groupFilter(maskedFieldSet);
            ThreadLocalCache.setFields(dataClass, MaskedField.class, maskedFieldSet);
        }
        if (!CollectionUtils.isEmpty(maskedFieldSet)) {
            for (Field field:maskedFieldSet) {
                ReflectionUtils.makeAccessible(field);
                Object value = ReflectionUtils.getField(field, data);
                ReflectionUtils.setField(field, data, doMask(value, field.getAnnotation(MaskedField.class)));
            }
        }

        Set<Field> maskedSet = ThreadLocalCache.getFields(dataClass, Masked.class);
        if (maskedSet == null) {
            maskedSet = getFields(dataClass, Masked.class);
            ThreadLocalCache.setFields(dataClass, Masked.class, maskedSet);
        }
        if (!CollectionUtils.isEmpty(maskedSet)) {
            for (Field field:maskedSet) {
                ReflectionUtils.makeAccessible(field);
                Object value = ReflectionUtils.getField(field, data);
                convert(value);
            }
        }
    }

    private Set<Field> groupFilter(Set<Field> maskedFieldSet) {
        Masked masked = ThreadLocalCache.getMasked();
        if (masked.groups().length == 0) {
            return maskedFieldSet;
        }
        return maskedFieldSet.stream().filter(f -> {
            for (String fieldGroup : f.getAnnotation(MaskedField.class).groups()) {
                for (String group : masked.groups()) {
                    if (Objects.equals(fieldGroup, group)) {
                        return true;
                    }
                }
            }
            return false;
        }).collect(Collectors.toSet());
    }

    private Set<Field> getFields(Class dataClass, Class annotationClass) {
        Set<Field> finalMaskedFieldSet = new HashSet<>();
        ReflectionUtils.doWithFields(dataClass, finalMaskedFieldSet::add, f -> f.isAnnotationPresent(annotationClass));
        return finalMaskedFieldSet;
    }

    private Object doMask(Object value, MaskedField maskedField) {
        if (maskedField != null && value instanceof String && StringUtils.hasText((String) value)) {
            return dataMaskHandlerSelector.doMask(maskedField.value(), maskedField.id(), value);
        }
        return value;
    }

}
