package com.bin.mq.distribute;

import com.alibaba.fastjson.JSONObject;
import com.bin.adapter.MessageAdapter;
import com.bin.constants.MQconf;
import com.bin.service.MailService;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: Consumer <br/>
 * Description: <br/>
 * date: 2019/11/30 20:12<br/>
 * 消费分发类
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Component
public class Consumer {
    private static Logger log = LogManager.getLogger(Consumer.class);
    @Autowired
    private MailService mailService;
    @JmsListener(destination = "mail_queue")
    public void distribute(String json) {
        log.info("###消息服务###收到消息,消息内容 json:{}", json);
        if (StringUtils.isEmpty(json)) {
            return;
        }
        JSONObject jsonObject = new JSONObject().parseObject(json);
        JSONObject header = jsonObject.getJSONObject("head");
        String mqCode = header.getString("mqCode");
        MessageAdapter messageAdapter = null;
        switch (mqCode) {
            // 发送邮件
            case MQconf.SMS_MAIL:
                messageAdapter=mailService;
                break;
            default:
                break;
        }
        JSONObject content=jsonObject.getJSONObject("content");
        messageAdapter.distribute(content);

    }
}
