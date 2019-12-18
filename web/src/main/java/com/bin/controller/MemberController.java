package com.bin.controller;

import com.bin.entity.Member;
import com.bin.feign.MemberFeign;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
    private static Logger log = LogManager.getLogger(MemberController.class);
    @Resource
    private MemberFeign memberFeign;
    @RequestMapping("/login")
    public String login(@RequestParam("phone") String phone,@RequestParam("password") String password){
        log.info("进入membercontroller/login"+phone+"***"+password);
        Member member = new Member(phone,password);
        Map<String,Object> result = new HashMap<>();
        result = memberFeign.login(member);
        if("2998".equals(result.get("rsp_code"))) {
            return "login";
        }
        Object data = result.get("data");
        log.info(data.toString());
        return "memberCen";

    }
}
