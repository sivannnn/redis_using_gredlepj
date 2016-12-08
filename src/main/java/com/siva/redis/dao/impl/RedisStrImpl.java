package com.siva.redis.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.siva.redis.dao.RedisStrDao;
import com.siva.redis.entity.RedisResponse;

public class RedisStrImpl implements RedisStrDao{
    @Autowired
    protected RedisTemplate<?, ?> redisTemplate;
    
    public RedisResponse setValue(String key, String value) {
        return redisTemplate.execute(new RedisCallback<RedisResponse>() {
            public RedisResponse doInRedis(RedisConnection conn) throws DataAccessException {
                try {
                    conn.set(redisTemplate.getStringSerializer().serialize(key)
                            ,redisTemplate.getStringSerializer().serialize(value));
                    return new RedisResponse(SUCCESS,null);
                } catch (Exception e) {
                    return new RedisResponse(FAIL, e.getMessage());
                }
            }
        });
    }

    public RedisResponse getValue(String key) {
        return redisTemplate.execute(new RedisCallback<RedisResponse>() {
            public RedisResponse doInRedis(RedisConnection conn) throws DataAccessException {
                try {
                    byte[] redisKey = redisTemplate.getStringSerializer().serialize(key);
                    if(conn.exists(redisKey)){
                        byte[] value = conn.get(redisKey);
                        return new RedisResponse(SUCCESS,(Object)redisTemplate.getStringSerializer().deserialize(value));
                    }else{
                        return new RedisResponse(FAIL,KEY_NON_EXISTENT);
                    }
                } catch (Exception e) {
                    return new RedisResponse(FAIL,e.getMessage());
                }
            }
        });
    }

    public RedisResponse delByKey(String key) {
        return redisTemplate.execute(new RedisCallback<RedisResponse>() {
            public RedisResponse doInRedis(RedisConnection conn) throws DataAccessException {
                try {
                    byte[] redisKey = redisTemplate.getStringSerializer().serialize(key);
                    if(conn.exists(redisKey)){
                        conn.del(redisKey);
                        return new RedisResponse(SUCCESS,"");
                    }else{
                        return new RedisResponse(FAIL,KEY_NON_EXISTENT);
                    }
                } catch (Exception e) {
                    return new RedisResponse(FAIL,e.getMessage());
                }
            }
        });
    }

}
