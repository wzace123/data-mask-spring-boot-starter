package org.wz.datamask.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClassFieldsLocalCache {

    private static ThreadLocal<Map<Class, Map<Class, Set<Field>>>> classFieldsLocalCache = ThreadLocal.withInitial(HashMap::new);

    public static void clean() {
        classFieldsLocalCache.remove();
    }

    public static Set<Field> getFields(Class cls, Class annotationClass) {
        Map<Class, Map<Class, Set<Field>>> classCache = classFieldsLocalCache.get();
        if (classCache != null) {
            Map<Class, Set<Field>> fieldsCache = classCache.get(cls);
            if (fieldsCache != null) {
                return fieldsCache.get(annotationClass);
            }
        }
        return null;
    }

    public static void setFields(Class cls, Class annotationClass, Set<Field> fields) {
        Map<Class, Map<Class, Set<Field>>> classCache = classFieldsLocalCache.get();
        Map<Class, Set<Field>> fieldsCache = classCache.get(cls);
        if (fieldsCache == null) {
            fieldsCache = new HashMap<>();
            fieldsCache.put(annotationClass, fields);
            classCache.put(cls, fieldsCache);
        } else {
            if (fieldsCache.get(annotationClass) == null) {
                fieldsCache.put(annotationClass, fields);
            } else {
                fieldsCache.get(annotationClass).addAll(fields);
            }
        }
    }


}
