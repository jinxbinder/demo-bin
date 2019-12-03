package com.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.jms.annotation.EnableJms;

/**
 * ClassName: MemberServer <br/>
 * Description: <br/>
 * date: 2019/11/20 17:16<br/>
 * 会员服务启动器
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@EnableJms
@SpringBootApplication
@EnableEurekaClient
public class MemberServer {
    public static void main(String[] args) {
        SpringApplication.run(MemberServer.class,args);
    }
}
