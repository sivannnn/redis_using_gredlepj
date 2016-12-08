package com.siva.redis.entity;

import java.io.Serializable;

/**
 * 封装redis查询结果.<br>
 * @author siva
 * @version v1.0
 */
public class RedisResponse implements Serializable{
    
    private static final long serialVersionUID = 1L;
    /**
     * 是否成功标识(1:成功,2:失败).
     */
    private int flag;
    /**
     * 失败信息.
     */
    private String msg;
    /**
     * 操作结果.
     */
    private Object data;
    
    public RedisResponse(){}
    
    public RedisResponse(int flag,Object data){
        this.flag = flag;
        this.data = data;
    }
    
    public RedisResponse(int flag,String msg){
        this.flag = flag;
        this.msg = msg;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return "RedisResponse [flag=" + flag + ", msg=" + msg + ", data=" + data + "]";
    }
    
    
}
