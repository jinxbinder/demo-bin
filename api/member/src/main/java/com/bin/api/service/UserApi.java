package com.bin.api.service;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: UserApi <br/>
 * Description: <br/>
 * date: 2020/3/13 20:27<br/>
 *
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@RequestMapping("/user")
public interface UserApi {
    @RequestMapping("/findAll")
    public String findAll();
}
