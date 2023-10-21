package org.wz.datamask.handle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Data Mask Handler Selector
 */
public class DataMaskHandlerSelector implements ApplicationContextAware {

    private Map<String, DataMaskHandler> serviceMap = new HashMap<>();

    public Object doMask(String fieldType, String id, Object value) {
        DataMaskHandler handler = getService(fieldType, id);
        if (handler != null) {
            return handler.doMask((String) value);
        }
        return value;
    }

    protected DataMaskHandler getService(String fieldType, String id) {
        return serviceMap.get(id + "_" + fieldType);
    }

    public void setServiceMap(Map<String, DataMaskHandler> serviceMap) {
        this.serviceMap = serviceMap;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String,DataMaskHandler> handlers = applicationContext.getBeansOfType(DataMaskHandler.class);
        handlers.values().forEach(handler->{
            serviceMap.putIfAbsent(handler.getId() + "_" + handler.getFieldType() ,handler);
        });
    }
}
