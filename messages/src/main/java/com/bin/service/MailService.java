package com.bin.service;

import com.alibaba.fastjson.JSONObject;
import com.bin.adapter.MessageAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * ClassName: MailService <br/>
 * Description: <br/>
 * date: 2019/11/29 23:37<br/>
 * 邮箱服务
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Service
public class MailService implements MessageAdapter {
    private static Logger log = LogManager.getLogger(MailService.class);
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String sender; // 读取配置文件中的参数
    @Override
    public void distribute(JSONObject jsonObject) {
        String mail=jsonObject.getString("mail");
        String userName=jsonObject.getString("userName");
        log.info("###消费者收到消息... mail:{},userName:{}",mail,userName);
        // 发送邮件
        // 开始发送邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(mail);
        log.info("====from:"+sender);
        log.info("===to:"+mail);
        message.setSubject("商城会员注册成功");
        message.setText("恭喜您"+userName+",成为微信商城的新用户!谢谢您的光临!");
        log.info("###发送短信邮箱 mail:{}", mail);
        try {
            mailSender.send(message);
        } catch (MailException e) {
            log.error("邮件发送失败=====",e);
        }

    }
}
