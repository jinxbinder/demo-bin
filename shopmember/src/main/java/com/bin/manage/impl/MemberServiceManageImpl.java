package com.bin.manage.impl;


import com.alibaba.fastjson.JSONObject;
import com.bin.common.api.BaseApiService;
import com.bin.common.redis.BaseRedisService;
import com.bin.common.utils.DateUtil;
import com.bin.common.utils.MD5Util;
import com.bin.common.utils.TokenUtil;
import com.bin.constants.DBconf;
import com.bin.constants.MQconf;
import com.bin.dao.MemberDao;
import com.bin.entity.Member;
import com.bin.entity.User;
import com.bin.entity.UserExample;
import com.bin.manage.MemberServiceManage;
import com.bin.mapper.UserMapper;
import com.bin.mq.producer.SignMailProducer;


import org.apache.commons.lang.StringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ClassName: MemberServiceManageImpl <br/>
 * Description: <br/>
 * date: 2019/11/27 11:03<br/>
 * 会员业务代码
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Service
public class MemberServiceManageImpl extends BaseApiService implements MemberServiceManage {
    @Autowired
    private BaseRedisService baseRedisService;
    @Autowired
    private SignMailProducer signMailProducer;
    @Value("${messages.queue}")
    private String MESSAGES_QUEUE;
    @Autowired
    private MemberDao memberDao;
    @Resource
    private UserMapper userMapper;
    @Autowired
    private TokenUtil tokenUtil;
    Logger log = LogManager.getLogger(MemberServiceManageImpl.class);
    @Override
    public Map<String, Object> getMember(String token) {
        String userId = baseRedisService.get(token);
        if(StringUtils.isEmpty(userId)){
            return setErrData("用户身份已过期");
        }
        Integer id = Integer.parseInt(userId);
        Member member = memberDao.getMemberInfo(id);
        member.setPassword(null);
        return setSuccessData(member);
    }
    /**
    * Description: 功能描述（会员注册功能） <br/>
    * date: 2019/12/3 16:30<br/>
    * @author libd <br/>
    */
    @Override
    public Map<String, Object> sign(Member member) {
        member.setCreated(DateUtil.getTimestamp());
        member.setUpdated(DateUtil.getTimestamp());
        member.setPassword(md5PassSalt(member.getPhone(),member.getPassword()));
        try {
            memberDao.save(member, DBconf.TABLE_MB_USER);
        } catch (Exception e) {

            log.error("***sql插入错误：",e);
            return setErrData("注册失败,用户名或手机号已存在");
        }
/*        //队列
        Destination activeMQQueue = new ActiveMQQueue(MESSAGES_QUEUE);
        // 组装报文格式
        String mailMessage = mailMessage(member.getEmail(), member.getUsername());
        log.info("###regist() 注册发送邮件报文mailMessage:{}", mailMessage);
        // mq
        signMailProducer.send(activeMQQueue, mailMessage);*/
        return setSuccessData("注册成功");
    }
    /**
    * Description: 功能描述（MD5加盐） <br/>
    * date: 2019/11/29 23:12<br/>
    * @author libd <br/>
    */
    @Override
    public String md5PassSalt(String phone, String password) {
        String newPass = MD5Util.MD5(phone + password);
        return newPass;
    }
    /**
    * Description: 功能描述（会员登录） <br/>
    * date: 2019/12/15 12:39<br/>
    * @author libd <br/>
    */
    @Override
    public Map<String, Object> login(String username,String password) {

        //String passSalt = md5PassSalt(username,password);
        //Member memberInfo = memberDao.getLogin(username,passSalt);
        log.info(username+password);
        User userInfo = null;
        try {
            userInfo = userMapper.selectByPrimaryKey(103L);
            log.info(userInfo.toString());
        } catch (Exception e) {
            log.error("查询异常",e);
        }
        if(userInfo == null){
            return setErrData("手机号或密码不正确");
        }
        String token = tokenUtil.getToken();
        String memberId = userInfo.getUserId()+"";
        baseRedisService.set(memberId,token, 600L);
        return setSuccessData(token);
    }
    /**
    * Description: 功能描述（页面跳转） <br/>
    * date: 2020/3/11 21:23<br/>
    * @author libd <br/>  
    */
    @Override
    public String page(String url) {
        return url;
    }

    /**
    * Description: 功能描述（邮箱消息报文拼装） <br/>
    * date: 2019/11/30 19:25<br/>
    * @author libd <br/>
    */
    private String mailMessage(String email, String userName) {
        JSONObject root = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("mqCode", MQconf.SMS_MAIL);
        JSONObject content = new JSONObject();
        content.put("mail", email);
        content.put("userName", userName);
        root.put("head", header);
        root.put("content", content);
        return root.toJSONString();
    }
}
