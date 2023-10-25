package org.wz.datamask.util;

import org.wz.datamask.annotation.Masked;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ThreadLocalCache {

    private static ThreadLocal<Map<Object, Object>> threadLocalCache = ThreadLocal.withInitial(HashMap::new);

    public static Set<Field> getFields(Class cls, Class annotationClass) {
        Map<Object, Object> cache = threadLocalCache.get();
        if (cache != null) {
            Map<String, Set<Field>> fieldsCache = (Map<String, Set<Field>>) cache.get(cls.getName());
            if (fieldsCache != null) {
                return fieldsCache.get(annotationClass.getName());
            }
        }
        return null;
    }

    public static void setFields(Class cls, Class annotationClass, Set<Field> fields) {
        Map<Object, Object> cache = threadLocalCache.get();
        Map<String, Set<Field>> fieldsCache = (Map<String, Set<Field>>) cache.get(cls.getName());
        if (fieldsCache == null) {
            fieldsCache = new HashMap<>();
            fieldsCache.put(annotationClass.getName(), fields);
            cache.put(cls, fieldsCache);
        } else {
            if (fieldsCache.get(annotationClass.getName()) == null) {
                fieldsCache.put(annotationClass.getName(), fields);
            } else {
                fieldsCache.get(annotationClass.getName()).addAll(fields);
            }
        }
    }

    public static Masked getMasked() {
        Map<Object, Object> cache = threadLocalCache.get();
        return (Masked) cache.get(Masked.class.getName());
    }

    public static void setMasked(Masked masked) {
        Map<Object, Object> cache = threadLocalCache.get();
        cache.putIfAbsent(Masked.class.getName(), masked);
    }

    public static void clean() {
        threadLocalCache.remove();
    }

}
