package com.zhao.springboot.test.before.aop.test;


import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        BeforeAdvice advice = new GreetingBeforeAdvice();
        Waiter waiter = new NativeWaiter();

        ProxyFactory pf = new org.springframework.aop.framework.ProxyFactory();
        pf.setTarget(waiter);
        pf.addAdvice(advice);

        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");

        String configPath="classpath:ApplicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter wt = (Waiter) ctx.getBean("waiter");
        wt.serveTo("zhaohuan");

    }

}
