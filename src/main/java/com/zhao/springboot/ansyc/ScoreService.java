package com.zhao.springboot.ansyc;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @program: springboot
 * @description 测试异步框架，特别疯狂
 * @author: zhaohuan
 * @create: 2019-12-08 23:39
 **/
@Service
public class ScoreService {


    @Async
    public void sendRedPacket() throws InterruptedException {
        Thread.sleep(10000);
            System.out.println("send  red  packet ");
    }

    @Async
    public void sendSoce() throws InterruptedException {
        Thread.sleep(20000);
    }


}
