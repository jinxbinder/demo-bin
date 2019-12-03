package com.bin.common.api;

import com.bin.constants.BaseApiConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: BaseApiService <br/>
 * Description: <br/>
 * date: 2019/11/20 18:49<br/>
 * 通用工具类
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
public class BaseApiService implements BaseApiConstants{
    public static Logger log = LogManager.getLogger(BaseApiService.class);
    public Map<String,Object> setResult(String code, String desc, Object data){
        HashMap<String ,Object> result = new HashMap<>();
        result.put("rsp_code",code);
        result.put("desc",desc);
        result.put("data",data);
        return result;
    }

    public Map<String, Object> setSuccess(){
        HashMap<String,Object> result = new HashMap<>();
        result.put("rsp_code", HTTP_200_CODE);
        result.put("desc",RSP_DESC_SUCCESS);
        return  result;
    }

    public Map<String, Object> setSuccessData(Object data){
        HashMap<String,Object> result = new HashMap<>();
        result.put("rsp_code", HTTP_200_CODE);
        result.put("desc",RSP_DESC_SUCCESS);
        result.put("data",data);

        return  result;
    }
    /**
    * Description: 功能描述（输出失败编码和自定义信息） <br/>
    * date: 2019/11/27 10:53<br/>
    * @author libd <br/>
    */
    public Map<String,Object> setErrData(Object data){
        HashMap<String,Object> result = new HashMap<>();
        result.put("rsp_code",HTTP_400_CODE);
        result.put("desc",data);

        return result;
    }
}
