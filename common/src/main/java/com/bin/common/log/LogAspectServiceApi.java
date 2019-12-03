package com.bin.common.log;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * ClassName: LogAspectServiceApi <br/>
 * Description: <br/>
 * date: 2019/11/25 0:28<br/>
 * aop日志打印
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Aspect
@Component
public class LogAspectServiceApi {
    Logger log = LogManager.getLogger(LogAspectServiceApi.class);
    private JSONObject jsonObject = new JSONObject();

    // 申明一个切点 里面是 execution表达式
    @Pointcut("execution(* com.bin.api.service.*.*(..))")
    private void controllerAspect() {
    }
    // 请求method前打印内容
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("===============request start===============");
        try {
            // 打印请求内容
            log.info("请求地址:" + request.getRequestURL().toString());
            log.info("请求方式:" + request.getMethod());
            log.info("请求类方法:" + joinPoint.getSignature());
            log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        } catch (Exception e) {
            log.error("###LogAspectServiceApi.class methodBefore() ### ERROR:", e);
        }
        log.info("===============request end===============");
    }

    // 在方法执行完结后打印返回内容
    @AfterReturning(returning = "o", pointcut = "controllerAspect()")
    public void methodAfterReturing(Object o) {
        log.info("--------------response start----------------");
        try {
            log.info("Response内容:" + jsonObject.toJSONString(o));
        } catch (Exception e) {
            log.error("###LogAspectServiceApi.class methodAfterReturing() ### ERROR:", e);
        }
        log.info("--------------response end----------------");
    }
}
