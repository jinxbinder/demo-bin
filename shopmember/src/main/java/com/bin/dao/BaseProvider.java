package com.bin.dao;

import com.bin.common.utils.ReflectionUtil;
import org.apache.ibatis.jdbc.SQL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * ClassName: BaseProvider <br/>
 * Description: <br/>
 * date: 2019/11/26 16:36<br/>
 * 插入适配语句
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
public class BaseProvider {
    Logger log = LogManager.getLogger(BaseProvider.class);
    public String save(Map<Object,String> map){
        final Object object = map.get("oj");
        final String table = map.get("table");
        log.info("***进入save（）：table="+table);
        log.info("param:"+object.toString());
        SQL sql = new SQL(){
            {
                INSERT_INTO(table);
                VALUES(ReflectionUtil.getFieldParam(object),ReflectionUtil.getFieldValue(object));
            }
        };
        log.info("***sql:"+sql);
        log.info("***save（）执行结束");
        return sql.toString();
    }
}
