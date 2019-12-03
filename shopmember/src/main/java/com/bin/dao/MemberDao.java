package com.bin.dao;

import com.bin.common.mybatis.BaseDao;
import com.bin.entity.Member;

import org.apache.ibatis.annotations.Mapper;
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
    Member getMemberInfo(Integer id);

}
