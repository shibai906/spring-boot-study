package com.zhao.springboot.rabbitmq;

import com.zhao.springboot.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDirectQueue() {
        User user = new User();
        user.setName("zhaohuan");
        user.setUserId("12345");
        System.out.println("sendDirectQueue已经发送消息");
        amqpTemplate.convertAndSend(RabbitMQConfig.QUEUE,user);
    }

}
