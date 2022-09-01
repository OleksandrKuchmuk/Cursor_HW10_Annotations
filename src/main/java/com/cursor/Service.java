package com.cursor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Service {
    public static final Logger LOGGER = LogManager.getLogger(Service.class);

    public void print(Object o, Class c) {
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(Show.class)) {
                    field.setAccessible(true);
                    try {
                        LOGGER.info("\""+field.getName()+"\"" + " - " +field.get(o));
                    } catch (IllegalAccessException e) {
                        LOGGER.error("IllegalAccessException in print method");
                    }
                }
            }
        }
    }
}
