package com.siva.redis.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.siva.redis.dao.RedisListdao;
import com.siva.redis.entity.RedisResponse;

public class RedisListImpl implements RedisListdao{
    @Autowired
    protected RedisTemplate<?, ?> redisTemplate;

    @Override
    public RedisResponse saveValueR(String key, String value) {
        return redisTemplate.execute(new RedisCallback<RedisResponse>() {
            public RedisResponse doInRedis(RedisConnection conn) throws DataAccessException {
                conn.rPush(redisTemplate.getStringSerializer().serialize(key)
                        , redisTemplate.getStringSerializer().serialize(value));
                return null;
            }
        });
    }

    @Override
    public RedisResponse getRangeL(String key, String begin, String length) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RedisResponse getIndexL(String key, String location) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RedisResponse delvalueL(String key) {
        // TODO Auto-generated method stub
        return null;
    }

}
