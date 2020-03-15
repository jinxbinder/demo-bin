package com.bin.controller;

import com.bin.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: UserController <br/>
 * Description: <br/>
 * date: 2020/3/13 21:53<br/>
 *
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Controller
public class UserController {
    @Autowired
    private UserFeign userFeign;
    @RequestMapping("/findAll")
    public String findAll(){
        return userFeign.findAll();
    }
}
