package com.bin.controller;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

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

    @RequestMapping("/index")
    public String index(){
        System.out.println("进入index方法=======================");
        return "index";
    }
}
