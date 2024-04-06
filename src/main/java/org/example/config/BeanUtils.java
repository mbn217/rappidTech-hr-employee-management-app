package org.example.config;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Custom component that can retrieve any Bean on the application.
 */
@Component
public class BeanUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setContext(applicationContext);
    }

    public static void setContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtils.context = applicationContext;
    }

    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    public static <T> T getBean(String bean, Class<T> beanClass){
        return context.getBean(bean, beanClass);
    }

    public static String getProperty(String key) {
        return context.getEnvironment().getProperty(key);
    }

    public static String getEntityTableName(Class<?> clazz){
        String toReturn = getTableNameFromClass(clazz);

        if(StringUtils.isBlank(toReturn)){
            // if no entity name found, loop through superclasses until annotation is found.

            Class<?> superClazz = clazz.getSuperclass();
            while(StringUtils.isBlank(toReturn) && superClazz != Object.class){
                // while no superclass annotation has been found AND while the superclass chain hasn't ended on Object.class,

                toReturn = getTableNameFromClass(superClazz);
                superClazz = superClazz.getSuperclass(); // get current class's superclass for next loop
            }

        }

        return toReturn;
    }

    private static String getTableNameFromClass(Class<?> clazz){
        String toReturn =  clazz.getAnnotation(Entity.class) == null ? null : clazz.getAnnotation(Entity.class).name();
        if(StringUtils.isBlank(toReturn)) {
            toReturn = clazz.getAnnotation(Table.class) == null ? null : clazz.getAnnotation(Table.class).name();
        }
        return toReturn;
    }
}
