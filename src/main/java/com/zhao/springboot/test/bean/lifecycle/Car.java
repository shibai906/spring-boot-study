package com.zhao.springboot.test.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Car implements BeanFactoryAware , BeanNameAware , InitializingBean , DisposableBean {

    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("调用Car（）构造函数");
    }

    public void setBrand(String brand) {
        System.out.println("设置brand() 设置属性");
        this.brand = brand;
    }

    public void setColor(String color) {
        System.out.println("设置了color属性");
        this.color = color;
    }


    public String introduce() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", beanFactory=" + beanFactory +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    public void setMaxSpeed(int maxSpeed) {
        System.out.println("设置了MaxSpeed属性");
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("调用BeanNameAware.setBeanName()");
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destory().");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("调用init-method所指定的myInit(),将maxSpeed设置为240.");
        this.setMaxSpeed(240);
    }

    // 通过<bean>的destroy-method属性指定的销毁方法
    public void myDestroy() {
        System.out.println("调用destory-method所指定的myDestroy().");
    }

}
