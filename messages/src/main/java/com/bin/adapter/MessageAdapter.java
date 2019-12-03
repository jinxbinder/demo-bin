package com.bin.adapter;

import com.alibaba.fastjson.JSONObject;

/**
 * ClassName: MessageAdapter <br/>
 * Description: <br/>
 * date: 2019/11/29 23:32<br/>
 * 消息转发适配器
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
public interface MessageAdapter {
    //接受消息
    void distribute(JSONObject jsonObject);
}
