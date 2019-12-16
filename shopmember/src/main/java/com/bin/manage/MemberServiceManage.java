package com.bin.manage;

import com.bin.entity.Member;

import java.util.Map;

/**
 * ClassName: MemberServiceManage <br/>
 * Description: <br/>
 * date: 2019/11/27 11:02<br/>
 * 注册会员服务
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */

public interface MemberServiceManage {
    //获取用户信息
    Map<String,Object> getMember(String token);
    //会员注册
    Map<String,Object> sign(Member member);
    //MD5加盐
    String md5PassSalt(String phone, String password);
    //会员登录
    Map<String,Object> login(Member member);

}
