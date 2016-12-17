package com.sh.crm.staff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/12/17.
 */
@Controller
public class StaffController {

    @RequestMapping("/login.action")
    public ModelAndView login(HttpServletRequest request) {
        String staffName = request.getParameter("loginName");

        System.out.println(staffName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/frame");
        return modelAndView;
    }
}
