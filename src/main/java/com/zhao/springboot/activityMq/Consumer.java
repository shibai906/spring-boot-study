package com.zhao.springboot.activityMq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.annotation.JmsListeners;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @JmsListener( destination =  "test.queue")
    public void receiveMsg(String text) {
        System.out.println("<<<<<========= 收到消息：" + text);
    }
    @JmsListener(destination = "test.topic" , containerFactory = "myJmsContainerFactory")
    public void subscribe(String text) {
        System.out.println("======<<<<<<收到订阅的消息" + text);
    }

    @JmsListener(destination = "test.topic" , containerFactory = "myJmsContainerFactory")
    public void receiveTwo(String text) {
        System.out.println("======<<<<<<收到订阅的消息2" + text);
    }

    @JmsListener(destination = "test.topic" )
    public void receiveTo(String text) {
        System.out.println("======<<<<<<收到订阅的消息" + text);
    }

}
