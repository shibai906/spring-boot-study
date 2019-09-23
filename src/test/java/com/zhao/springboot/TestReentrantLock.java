package com.zhao.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.locks.ReentrantLock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestReentrantLock {

    @Test
    public void test() {
        ReentrantLock re = new ReentrantLock();

        re.lock();
    }

}
