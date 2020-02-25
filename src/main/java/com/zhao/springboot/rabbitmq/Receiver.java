package com.zhao.springboot.rabbitmq;

import com.zhao.springboot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
//@Slf4j
public class Receiver {

    // queues是指要监听队列的名字
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiverDirectQueue(User user) {
        System.out.println("{receiverDirectQueue监听到消息}" + user.toString());
    }

}
