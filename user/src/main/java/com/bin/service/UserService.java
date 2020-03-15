package com.bin.service;

import com.bin.api.service.UserApi;
import com.bin.dao.UserRepository;
import com.bin.entity.User1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: UserService <br/>
 * Description: <br/>
 * date: 2020/3/13 21:42<br/>
 *
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Slf4j
@Service
public class UserService implements UserApi {
    @Autowired
    private UserRepository userRepository;
    @Override
    public String findAll() {
        List<User1> user1List =  userRepository.findAll();
        log.info(user1List.toString());
        return "ok";
    }
}
