package com.zhao.springboot;

import com.zhao.springboot.activityMq.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestActivityMq {

    @Resource
    private Producer producer;

    @Test
    public void contextLoads() {
        for(int i = 0 ; i < 10 ; i ++) {
            producer.sendMsg("test.queue", "Topic Message" + i);
        }
    }

    @Test
    public void pushLishTopic() {
        for(int i = 0 ; i < 10 ; i ++) {
            producer.publish("test.topic", "Topic Message" + i);
        }
    }


}
