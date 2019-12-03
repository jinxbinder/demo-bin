package com.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ClassName: MessagesService <br/>
 * Description: <br/>
 * date: 2019/11/30 20:17<br/>
 * 消息服务启动器
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableEurekaClient
public class MessagesService {
    public static void main(String[] args) {
        SpringApplication.run(MessagesService.class,args);
    }
}
