package com.zhao.springboot.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:ApplicationContext.xml") ;

        TestBean testBean = (TestBean) applicationContext.getBean("testBean");
        testBean.fun();

        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(TestBean.class);
        TestBean testBean1 = (TestBean) applicationContext1.getBean("testBean");
        testBean1.fun();
    }

}
