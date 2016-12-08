package com.siva.redis.dao;

import com.siva.pub.Constants;
import com.siva.redis.entity.RedisResponse;

/**
 * 字符串类型数据操作接口。<br>
 * @author siva
 * @version v1.0
 */
public interface RedisStrDao extends Constants{
    /**
     * 保存键值。
     * @param key key
     * @param value value
     * @return 操作结果
     */
    public RedisResponse setValue(String key,String value);
    /**
     * 根据key取value。
     * @param key key
     * @return value
     */
    public RedisResponse getValue(String key);
    /**
     * 根据key删除键值。
     * @param key key
     */
    public RedisResponse delByKey(String key);
}
