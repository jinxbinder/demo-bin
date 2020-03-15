package com.bin.api.service;

import com.bin.entity.Member;
import com.bin.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * ClassName: MemberService <br/>
 * Description: <br/>
 * date: 2019/11/27 10:31<br/>
 * 会员服务接口暴露
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@RequestMapping("/member")
public interface MemberService {
    /**
    * Description: 功能描述（根据token返回会员信息） <br/>
    * date: 2019/11/27 10:44<br/>
    * @author libd <br/>
    */
    @RequestMapping("/getMember")
    Map<String,Object> getMember(String token);
    /**
    * Description: 功能描述（会员注册接口） <br/>
    * date: 2019/11/29 15:42<br/>
    * @author libd <br/>
    */
    @RequestMapping("/sign")
    Map<String,Object> sign(@RequestBody Member member);
    /**
    * Description: 功能描述（会员登录接口） <br/>
    * date: 2019/12/15 12:22<br/>
    * @author libd <br/>
    */
    @GetMapping("/login")
    Map<String,Object> login(@RequestParam("username") String username, @RequestParam("password") String password);
    /**
    * Description: 功能描述（页面跳转） <br/>
    * date: 2020/3/11 21:15<br/>
    * @author libd <br/>  
    */
    @GetMapping("/page")
    String page(@RequestParam("url") String url);
}
