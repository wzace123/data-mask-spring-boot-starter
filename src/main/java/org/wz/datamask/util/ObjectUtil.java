package org.wz.datamask.util;

import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import org.wz.datamask.annotation.Masked;

import java.lang.reflect.Method;

public class ObjectUtil {

    private static final String POINT = "\\.";
    private static final String GET_PREFIX = "get";

    public static Object getValue(Object data, Masked masked) {
        if (data == null) {
            return null;
        }

        if (masked == null) {
            return data;
        }

        String value = masked.value().trim();
        if (!StringUtils.hasText(value)) {
            return data;
        }

        String[] fieldNameArray = value.split(POINT);
        Object newData = data;
        for (String fieldName:fieldNameArray) {
            newData = getValue(newData, fieldName);
        }

        return newData;
    }

    public static Object getValue(Object data, String fieldName) {
        if (data == null) {
            return null;
        }
        Class dataClass = data.getClass();
        String methodName = GET_PREFIX + getMethodName(fieldName);
        Method method = ReflectionUtils.findMethod(dataClass, methodName);
        Assert.notNull(method, "can not find method:" + methodName + " in " + dataClass.getName());
        return ReflectionUtils.invokeMethod(method, data);
    }

    public static String getMethodName(String fieldName) {
        char[] chars = fieldName.toCharArray();
        chars[0] = toUpperCase(chars[0]);
        return String.valueOf(chars);
    }

    public static char toUpperCase(char c) {
        if (97 <= c && c <= 122) {
            c ^= 32;
        }
        return c;
    }
}
