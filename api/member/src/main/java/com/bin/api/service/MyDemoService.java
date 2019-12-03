package com.bin.api.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * ClassName: MyDemoService <br/>
 * Description: <br/>
 * date: 2019/11/20 16:54<br/>
 * 暴露接口---demo
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@RequestMapping("/demo")
public interface MyDemoService {
    @GetMapping("/dd")
    public Map<String,Object> demo();
    @GetMapping("/setKey")
    public Map<String,Object> setKey(String key,String value,Long timeOut);
    @GetMapping("/getKey")
    public Map<String,Object> getKey(String key);
}
