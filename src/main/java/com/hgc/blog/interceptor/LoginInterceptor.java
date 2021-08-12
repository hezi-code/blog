package com.hgc.blog.interceptor;/**
 * ClassName:LoginInterceptor
 * Package:com.hgc.blog.interceptor
 * description:
 *
 * @Date:2021/3/29 16:16
 * @aUTHOR:HGC
 */

import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *ClassName:LoginInterceptor
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }

}
