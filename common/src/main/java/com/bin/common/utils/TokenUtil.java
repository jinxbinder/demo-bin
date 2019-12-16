package com.bin.common.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * ClassName: TokenUtil <br/>
 * Description: <br/>
 * date: 2019/12/16 13:08<br/>
 * 令牌工具类
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Component
public class TokenUtil {
    public String getToken(){
        return UUID.randomUUID().toString();
    }
}
