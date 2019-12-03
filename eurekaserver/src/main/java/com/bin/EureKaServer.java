package com.bin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName: EureKaServer <br/>
 * Description: <br/>
 * date: 2019/11/20 14:42<br/>
 * spring cloud 服务注册中心启动器
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableEurekaServer
public class EureKaServer {
    public static void main(String[] args) {
        SpringApplication.run(EureKaServer.class,args);
    }
}
