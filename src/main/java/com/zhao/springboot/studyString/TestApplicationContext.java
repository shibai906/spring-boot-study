package com.zhao.springboot.studyString;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

public class TestApplicationContext {

    public static void main(String[] args) {
        /*ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"bean.xml","service.xml"});
        ApplicationContext ctx1 = new FileSystemXmlApplicationContext(new String[]{"bean.xml","service.xml"});
        Resource resource = new ClassPathResource("sni");*/

//        DefaultSingletonBeanRegistry

        String string = "haohuanzzzz";
        System.out.println(string.indexOf("z"));

    }

}
