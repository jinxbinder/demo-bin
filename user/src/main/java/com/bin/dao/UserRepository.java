package com.bin.dao;

import com.bin.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName: UserRepository <br/>
 * Description: <br/>
 * date: 2020/3/13 20:38<br/>
 *
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Repository
public interface UserRepository extends JpaRepository<User1,Integer>{

}
