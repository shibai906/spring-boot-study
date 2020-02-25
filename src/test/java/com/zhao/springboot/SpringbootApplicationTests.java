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
import redis.clients.jedis.params.sortedset.ZAddParams;

import javax.persistence.Temporal;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//@RunWith(SpringRunner.class)
//@SpringBootTest
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
    public void testSetBit() throws Exception {
        redisClient.setBit("zhaohuan:100",100,true);
    }

    @Test
    public void testSetBit1000() throws Exception {
        redisClient.setBit("zhaohuan:100",100000000000L , false);
    }

    @Test
    public void testGetBit() throws Exception {
        System.out.println(redisClient.getBit("zha",34234));
    }

    @Test
    public void testAddZset() throws Exception {
//        ZAddParams params = new ZAddParams();
        redisClient.zadd("zhao",100,"zhaohuan");
        redisClient.zadd("zhao",200,"zhaojiaxin");
        redisClient.zadd("zhao",150,"zhaoxiao");
        redisClient.zadd("zhao",60,"yanxing");
        redisClient.zadd("zhao",40,"xiongda");
        redisClient.zadd("zhao",10,"xiongda");
    }

    @Test
    public void testGetZset() throws Exception {
        Set<String> set = redisClient.zrangebyscore("zhao",0,150);

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

