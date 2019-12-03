package com.bin.mq.producer;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;


/**
 * ClassName: SignMailProducer <br/>
 * Description: <br/>
 * date: 2019/11/30 17:20<br/>
 * 邮箱消息生产者
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Service("signMailProducer")
public class SignMailProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    public void send(Destination destination, String json){
        jmsMessagingTemplate.convertAndSend(destination,json);
    }
}
