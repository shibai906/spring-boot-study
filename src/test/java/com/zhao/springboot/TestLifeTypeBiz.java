package com.zhao.springboot;

import com.zhao.springboot.service.LifeTypeBiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLifeTypeBiz {

    @Autowired
    LifeTypeBiz lifeTypeBiz;


    @Test
    public void testGet() {
        lifeTypeBiz.get(1);
    }

}
