package com.bin.controller;

import com.bin.entity.Member;
import com.bin.feign.MemberFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: MemberController <br/>
 * Description: <br/>
 * date: 2019/12/16 22:33<br/>
 * 会员接口远程调用
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Controller
public class MemberController {
    @Autowired
    private MemberFeign memberFeign;
    @RequestMapping("/login")
    public String login(Member member){
        System.out.println("进入membercontroller/login");
        memberFeign.login(member);
        return "ccc";

    }
}
