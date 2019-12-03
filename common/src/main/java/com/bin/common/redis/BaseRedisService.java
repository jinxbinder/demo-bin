package com.bin.common.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: BaseRedisService <br/>
 * Description: <br/>
 * date: 2019/11/22 10:45<br/>
 * 封装redis
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Component
public class BaseRedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public void setString(String key,String value,Long timeOut){
        set(key,value,timeOut);
    }
/**
* Description: 功能描述（设置key） <br/>
* date: 2019/11/24 22:33<br/>
* @author libd <br/>
*/
    public void set(String key,Object value,Long timeOut){
        if(value!=null){
            if(value instanceof String){
                String setValue = (String) value;
                stringRedisTemplate.opsForValue().set(key,setValue);
            }
            //设置有效期
            if(timeOut!=null)
                stringRedisTemplate.expire(key,timeOut, TimeUnit.SECONDS);
        }
    }
/**
* Description: 功能描述（获取key） <br/>
* date: 2019/11/24 22:32<br/>
* @author libd <br/>
*/
    public String get(String key){

        return stringRedisTemplate.opsForValue().get(key);
    }
/**
* Description: 功能描述（删除key） <br/>
* date: 2019/11/24 22:32<br/>
* @author libd <br/>
*/
    public void delete(String key){
        stringRedisTemplate.delete(key);
    }
}
