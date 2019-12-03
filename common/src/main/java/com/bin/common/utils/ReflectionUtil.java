package com.bin.common.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ClassName: ReflectionUtil <br/>
 * Description: <br/>
 * date: 2019/11/29 14:11<br/>
 * 反射取对象属性和值
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
public class ReflectionUtil {
    Logger log = LogManager.getLogger(ReflectionUtil.class);
    /**
    * Description: 功能描述（获取对象属性） <br/>
    * date: 2019/11/29 14:17<br/>
    * @author libd <br/>
    */
    public static String getFieldParam(Object oj){
        if(oj == null){
            return null;
        }
        Class classInfo = oj.getClass();
        Field[] fields = classInfo.getDeclaredFields();
        return getParam(fields);
    }
    /**
    * Description: 功能描述（对象属性拼接） <br/>
    * date: 2019/11/29 14:48<br/>
    * @author libd <br/>
    */
    public static String getParam(Field[] field){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<field.length;i++){
            sb.append(field[i].getName());
            if (i<field.length-1){
                sb.append(",");
            }
        }
        return sb.toString();
    }
    /**
    * Description: 功能描述（获取对象值） <br/>
    * date: 2019/11/29 14:56<br/>
    * @author libd <br/>
    */
    public static String getFieldValue(Object oj){
        if(oj == null){
            return null;
        }
        Class classInfo = oj.getClass();
        Field[] fields = classInfo.getDeclaredFields();
        return getValue(oj,fields);
    }
    /**
    * Description: 功能描述（对象值拼接） <br/>
    * date: 2019/11/29 14:56<br/>
    * @author libd <br/>
    */
    public static String getValue(Object oj,Field[] fields){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<fields.length;i++){
            try {
                Field field = fields[i];
                //操作私有属性
                field.setAccessible(true);
                Object value = field.get(oj);
                boolean flag = false;
                if (value != null && (value instanceof String || value instanceof Timestamp || value instanceof Date)) {
                    flag = true;
                }
                if (flag) {
                    sb.append("'");
                    sb.append(value);
                    sb.append("'");
                } else {
                    sb.append(value);
                }
                if (i < fields.length - 1) {
                    sb.append(",");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
