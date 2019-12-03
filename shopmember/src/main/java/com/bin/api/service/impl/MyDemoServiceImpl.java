package com.bin.api.service.impl;

import com.bin.api.service.MyDemoService;
import com.bin.common.api.BaseApiService;
import com.bin.common.redis.BaseRedisService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MyDemoServiceImpl <br/>
 * Description: <br/>
 * date: 2019/11/20 16:57<br/>
 * 接口实现类
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
public class MyDemoServiceImpl extends BaseApiService implements MyDemoService {
    private static Logger log = LogManager.getLogger(MyDemoService.class);
    @Autowired
    private BaseRedisService baseRedisService;

    HashMap<String,Object> result = new HashMap<>();
    @Override
    public Map<String,Object> demo() {
        return setSuccess();
    }

    @Override
    public Map<String, Object> setKey(String key, String value, Long timeOut) {
        log.info("设置缓存："+key+" value:"+value+" 失效时间"+timeOut);
        baseRedisService.setString(key,value,timeOut);
        return setSuccess();
    }

    @Override
    public Map<String, Object> getKey(String key) {
        if(key!=null)
            return setSuccessData(baseRedisService.get(key));
        return null;
    }
}
