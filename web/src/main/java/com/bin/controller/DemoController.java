package com.bin.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * ClassName: DemoController <br/>
 * Description: <br/>
 * date: 2019/12/16 16:54<br/>
 * 测试类
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Controller
public class DemoController {
    Logger log = LogManager.getLogger(DemoController.class);
    @RequestMapping("/index")
    public String index(){
        log.info("进入index方法======================");
        return "index";
    }
    @RequestMapping("/log")
    public String log(){
        log.info("进入log方法======================");
        return "login";
    }
}
