package com.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ClassName: WebServer <br/>
 * Description: <br/>
 * date: 2019/12/16 16:39<br/>
 * web启动类
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableEurekaClient
public class WebServer {
    public static void main(String[] args){
        SpringApplication.run(WebServer.class,args);
    }
}
