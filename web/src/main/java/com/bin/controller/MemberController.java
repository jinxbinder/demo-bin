package com.bin.controller;

import com.bin.common.utils.CookieUtil;
import com.bin.constants.WebConstants;
import com.bin.entity.Member;
import com.bin.feign.MemberFeign;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class MemberController extends BaseController{
    private static final String LOGIN = "login";
    private static final String SIGN = "sign";
    private static Logger log = LogManager.getLogger(MemberController.class);
    @Resource
    private MemberFeign memberFeign;
    @RequestMapping("/localLogin")
    public String localLogin(){
        return LOGIN;
    }
    @RequestMapping("/login")
    public String login(@RequestParam("phone") String phone, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response){
        log.info("进入membercontroller/login"+phone+"***"+password);
        Member member = new Member(phone,password);
        Map<String,Object> result = memberFeign.login(member);
        if(!"0000".equals(result.get("rsp_code"))) {
            String  err = (String) result.get("desc");
            return setError(request,err,LOGIN);
        }
        String token = (String) result.get("data");
        log.info(token);
        CookieUtil.addCookie(response, WebConstants.USER_TOKEN,token,WebConstants.COOKIE_TIME);
        return "memberCen";

    }
    @RequestMapping("/localSign")
    public String localSign(){
        return SIGN;
    }
    @RequestMapping("/sign")
    public String sign(Member member,HttpServletRequest request,HttpServletResponse response){

        Map<String,Object> result = memberFeign.sign(member);
        if(!"0000".equals(result.get("rsp_code"))) {
            String  err = (String) result.get("desc");
            return setError(request,err,SIGN);
        }

        return LOGIN;
    }
}
