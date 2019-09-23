package com.zhao.springboot.utils;


import com.zhao.enums.RedisTimeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/*@Configuration
@EnableCaching*/
@Service
public class RedisCacheConfig {

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean set(final  String key,Object value) {
        boolean result = true;
        try {
            ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
            operations.set(key,value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 不存在返回true，存在返回false
    public Boolean multiSetIfAbsent(Map<String,Object> map) {
        return redisTemplate.opsForValue().multiSetIfAbsent(map);
    }

    public boolean multiSet(Map<String,Object> map) {
        ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
        if(!operations.multiSetIfAbsent(map)) {
            return false;
        }
        operations.multiSet(map);
        return true;
    }

    public long increment(String key,RedisTimeEnum time) {
        ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
        long num = operations.increment(key);
        redisTemplate.expire(key,time.getValue(),TimeUnit.SECONDS);
        return num;
    }

    public long decrement(String key,RedisTimeEnum timeEnum,long times) {
        ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
        long num = operations.decrement(key,times);
        redisTemplate.expire(key,timeEnum.getValue(),TimeUnit.SECONDS);
        return num;
    }

    public Object setNewKey(String key,Object value) {
        return redisTemplate.opsForValue().getAndSet(key,value);
    }

    public List<Object> getList(List<String> keys) {
        return redisTemplate.opsForValue().multiGet(keys);
    }

    public boolean set(final String key, Object value, RedisTimeEnum time) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value,time.getValue(),TimeUnit.SECONDS);
            if(!operations.setIfAbsent(key,value)) { // 存在返回false，不存在返回true
                return result;
            }
            redisTemplate.expire(key + time.getValue(), time.getValue(), TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean isExist(String key) {
        return redisTemplate.hasKey(key);
    }

    public void overwriteValue(String key,Object value,int offset) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key,value,offset);
    }

    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    public void append(String key,String value) {
        redisTemplate.opsForValue().append(key,value);
    }

    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    public boolean tryLock(String key,RedisTimeEnum time,String value) {

        if(redisTemplate.hasKey(key + time.getValue())) {
            return false;
        }
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
//        operations.set(key,value,"NX","EX",1000L);
        operations.set(key + time.getValue(), value);
        redisTemplate.expire(key + time.getValue(), time.getValue(), TimeUnit.SECONDS);
        return true;
    }

    public void unLock(String key, RedisTimeEnum time ) {
        if(redisTemplate.hasKey(key + time.getValue())) {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            redisTemplate.delete(key + time.getValue());
        }
    }

    public long lpush(String key,String value) {
        ListOperations list = redisTemplate.opsForList();
        return list.leftPush(key,value);
    }

    public Object lpop(String key) {
        ListOperations list = redisTemplate.opsForList();
        return list.leftPop(key);
    }

    public List<Object> lpopAll(String key) {
        ListOperations<Serializable,Object> list = redisTemplate.opsForList();
        return list.range(key,0,-1);
    }

    public long size(String key) {
        return redisTemplate.opsForList().size(key);
    }

    public long leftPushAll(String key, Collection<Object> values) {
        return redisTemplate.opsForList().leftPushAll(key,values);
    }

    public long pushIfPresent(String key,Object value) {
        return redisTemplate.opsForList().leftPushIfPresent(key,value);
    }

    // 以下都是操作hash数据结构
    public void setHash(String key , String hashKey , Object value) {
        redisTemplate.opsForHash().put(key,hashKey,value);
    }

    public long deleteHashKey(String key , String ... hashKey) {
        return redisTemplate.opsForHash().delete(key,hashKey);
    }

    public Object getHash(String key,String hashKey) {
        return redisTemplate.opsForHash().get(key,hashKey);
    }

    public boolean setBit(String key , long offset , boolean flag) {
        return redisTemplate.opsForValue().setBit(key,offset,false);
    }

    public boolean getBit(String key , long offset ) {
        return redisTemplate.opsForValue().getBit(key,offset);
    }

}