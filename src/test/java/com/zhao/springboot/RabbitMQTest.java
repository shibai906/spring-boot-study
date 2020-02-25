package com.zhao.springboot;

import com.zhao.springboot.rabbitmq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private Sender sender;

    @Test
    public void testSenderMQ() {
        sender.sendDirectQueue();
    }

    public void testRedis() {

    }

}
