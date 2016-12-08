package com.siva.redis.dao;

import com.siva.pub.Constants;
import com.siva.redis.entity.RedisResponse;

/**
 * 列表类型数据操作接口。<br>
 * @author siva
 * @version v1.0
 */
public interface RedisListdao extends Constants{
    /**
     * 将给定值推入列表右端。
     * @param key 列表标识
     * @param value value
     * @return 操作结果
     */
    public RedisResponse saveValueR(String key,String value);
    
    /**
     * 获取列表在给定范围上的所有值。
     * @param key 列表标识
     * @param begin 开始位置
     * @param length 长度（-1：获取所有数据）
     * @return 操作结果
     */
    public RedisResponse getRangeL(String key,String begin,String length);
    
    /**
     * 获取列表在给定位置上的单个元素
     * @param key 列表标识
     * @param location 位置
     * @return 操作结果
     */
    public RedisResponse getIndexL(String key,String location);
    
    /**
     * 从列表的左端弹出一个值，并返回被弹出的值
     * @param key 列表标识
     * @return 操作结果
     */
    public RedisResponse delvalueL(String key);
}
