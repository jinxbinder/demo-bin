package com.bin.api.service.impl;

import com.bin.api.service.MemberService;
import com.bin.common.api.BaseApiService;
import com.bin.entity.Member;
import com.bin.manage.MemberServiceManage;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * ClassName: MemberServiceImpl <br/>
 * Description: <br/>
 * date: 2019/11/27 10:43<br/>
 *
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
public class MemberServiceImpl extends BaseApiService implements MemberService {
    @Autowired
    private MemberServiceManage memberServiceManage;
    @Override
    public Map<String, Object> getMember(String token) {
        return  StringUtils.isEmpty(token)? setErrData("token不能为空") : memberServiceManage.getMember(token);
    }

    @Override
    public Map<String, Object> sign(Member member) {
        if(StringUtils.isEmpty(member.getUsername())){
            return setErrData("用户名不能为空");
        }
        if(StringUtils.isEmpty(member.getPassword())){
            return setErrData("密码不能为空");
        }
        if (StringUtils.isEmpty(member.getPhone())){
            return setErrData("手机号不能为空");
        }
        return memberServiceManage.sign(member);
    }
}
