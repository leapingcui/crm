package com.sh.crm.classes.controller;

import com.sh.crm.classes.po.CourseType;
import com.sh.crm.classes.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/26.
 */
@Controller
public class CourseTypeController {

    @Autowired
    private CourseTypeService courseTypeService;

    @RequestMapping("/findAllCourseType")
    public ModelAndView findAllCourseType() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<CourseType> courseTypeList = courseTypeService.findCourseTypeByCondition(null);
            modelAndView.addObject("courseTypeList", courseTypeList);
            modelAndView.setViewName("/coursetype/listCourse");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping("/addCourseType")
    public ModelAndView addCourseType(CourseType courseType) {
        try {
            courseTypeService.addCourseType(courseType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findAllCourseType();
    }
}
