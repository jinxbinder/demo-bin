package com.bin.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: CookieUtil <br/>
 * Description: <br/>
 * date: 2019/12/21 14:33<br/>
 * web cookie工具类
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
public class CookieUtil {
    private CookieUtil() {
    }
    /**
    * Description: 功能描述（添加cookie） <br/>
    * date: 2019/12/21 14:34<br/>
    * @author libd <br/>
    */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }
    /**
    * Description: 功能描述（删除cookie） <br/>
    * date: 2019/12/21 14:35<br/>
    * @author libd <br/>
    */
    public static void removeCookie(HttpServletResponse response, String name) {
        Cookie uid = new Cookie(name, null);
        uid.setPath("/");
        uid.setMaxAge(0);
        response.addCookie(uid);
    }
    /**
    * Description: 功能描述（获取cookie） <br/>
    * date: 2019/12/21 14:36<br/>
    * @author libd <br/>
    */
    public static String getUid(HttpServletRequest request, String cookieName) {
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
