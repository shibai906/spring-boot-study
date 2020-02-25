package com.zhao.springboot.activityMq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTempTopic;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;

/**
 *  activityMq注释掉了
 */
// @Service
public class Producer {

    @Resource
    JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsg(String destinationName , String message) {
        System.out.println("=========>>>>>发送queue消息" + message);
        Destination destination = new ActiveMQQueue(destinationName);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    public void publish(String destinationName , String message) {
        Destination destination = new ActiveMQTopic(destinationName);
        System.out.println("=======>>>>>>发送topic消息" + message);
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    @Bean
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }

}
