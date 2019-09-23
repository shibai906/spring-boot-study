package com.zhao.springboot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.xml.ws.Action;
import java.util.List;
import java.util.Set;

@Component
public class RedisClient {
    @Autowired
    private JedisPool jedisPool;

    public void setBit(String key  , long id, boolean value) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.setbit(key,id,value);
            jedis.expire(key + id,10);
        } finally {
            // 返还给连接池
            jedis.close();
        }
    }

    public void zadd(String key  , double score, String member) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.zadd(key,score,member);
            jedis.expire(key,100);
        } finally {
            // 返还给连接池
            jedis.close();
        }
    }

    public Set<String> zreverange(String key  , long start, long end) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Set<String> set = jedis.zrevrange(key,start,end);
            return set;
        } finally {
            // 返还给连接池
            jedis.close();
        }
    }

    public Boolean getBit(String key , long id) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.getbit(key,id);
        } finally {
            // 返还给连接池
            jedis.close();
        }
    }

    public void set(String key , String value) throws Exception {
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.set(key,value);
            jedis.expire(key,1);
        } finally {
            // 返还给连接池
            jedis.close();
        }
    }

    public String get(String key) throws Exception {
        Jedis jedis = null ;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } finally {
            // 返还给连接池
            jedis.close();
        }
    }

    public Set<String> zrangebyscore(String key,double min , double max) {
        Jedis jedis = null ;
        try {
            jedis = jedisPool.getResource();
            return jedis.zrangeByScore(key , min ,max);
        } finally {
            // 返还给连接池
            jedis.close();
        }
    }

}
