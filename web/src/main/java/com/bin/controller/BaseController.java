package com.bin.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: BaseController <br/>
 * Description: <br/>
 * date: 2019/12/21 14:16<br/>
 *
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Controller
public class BaseController {
    public String setError(HttpServletRequest request, String msg, String addres) {
        request.setAttribute("error", msg);
        return addres;
    }
}
