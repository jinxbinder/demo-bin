package com.bin.dao;

import com.bin.entity.Member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName: MemberDao <br/>
 * Description: <br/>
 * date: 2019/11/27 11:30<br/>
 *
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Mapper
public interface MemberDao extends BaseDao {
    @Select("select * from mb_user where id = #{id}")
    Member getMemberInfo(@Param("id") Integer id);
    @Select("select id,username,phone,email from mb_user where phone = #{phone} and password = #{password}")
    Member getLogin(@Param("phone") String phone,@Param("password") String password);
}
