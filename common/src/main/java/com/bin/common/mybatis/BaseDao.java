package com.bin.common.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: BaseDao <br/>
 * Description: <br/>
 * date: 2019/11/26 16:24<br/>
 *
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
public interface BaseDao {
    @InsertProvider(type = BaseProvider.class,method = "save")
    public void save(@Param("oj") Object oj,@Param("table") String table);
}
