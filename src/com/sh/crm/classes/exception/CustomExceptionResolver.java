package com.sh.crm.classes.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/26.
 * 自定义异常处理器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        CustomException customException;
        e.printStackTrace();//打印错误信息
        if (e instanceof CustomException) {
            customException = (CustomException) e;
        } else {
            customException = new CustomException("未知错误，请和管理员联系");
        }
        modelAndView.addObject("message", e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
