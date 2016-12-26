package com.sh.crm.hr.interceptor;

import com.sh.crm.hr.po.Staff;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/23.
 * 登录拦截器：用于判断用户是否登录
 */
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o)
            throws Exception {
        String url = request.getRequestURI();
        if (url.indexOf("login.action") >= 0) {
            return true;
        }
        Staff staff = (Staff) request.getSession().getAttribute("staff");
        if (staff != null) {
            return true;
        }
        request.getRequestDispatcher("/pages/login.jsp").forward(request, response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object o, Exception e) throws Exception {

    }
}
