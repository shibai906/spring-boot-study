package com.zhao.springboot.test.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;
import java.util.concurrent.locks.ReentrantLock;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    // 仅对car bean处理，在对象实例化之前调用
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor.postProccessBeforeInitialization");
        }
        return null;
    }

    // 在实例化Bean后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        // 仅对容器中的car bean进行处理
        if("car".equals(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor.portProccessAfterInstantiation");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor.postProcessPropertyValues");
        }
        return pvs;
    }
}
