package com.zhao.springboot;

import com.zhao.springboot.entity.Person;
import com.zhao.springboot.entity.meal_card.Info;
import com.zhao.springboot.service.PersonService;
import com.zhao.springboot.service.meal_card.InfoService;
import com.zhao.springboot.utils.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    RedisClient redisClient ;

    @Test
    public void testSet() throws Exception {
        redisClient.set("zhao","huan");
    }

    @Test
    public void testGet() throws Exception {
        System.out.println(redisClient.get("zhao"));
    }

    @Test
    public void testTimeUnit() throws InterruptedException {
        System.out.println(TimeUnit.MICROSECONDS.convert(2000,TimeUnit.SECONDS));
        TimeUnit.MICROSECONDS.sleep(10000);
    }



    /*
    @Autowired
    PersonService personService;


    @Autowired
    InfoService infoService;

    @Test
    public void contextLoads() {
        List<Person> list = personService.getAll();
    }

    @Test
    public void insertInfo() {
        Info info = new Info();
        info.setName("赵欢");
        info.setNumber(140950229);
        info.setEntranceTime(System.currentTimeMillis());
        infoService.insert(info);
    }
*/
}

