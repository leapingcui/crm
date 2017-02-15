package com.sh.crm.classes.controller;

import com.sh.crm.classes.po.CourseType;
import com.sh.crm.classes.po.CourseTypeQueryVo;
import com.sh.crm.classes.service.CourseTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/26.
 */
@Controller
public class CourseTypeController {

    private static Logger logger = Logger.getLogger(CourseTypeController.class);
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

    @RequestMapping("/findCourseTypeByCondition")
    public ModelAndView findCourseTypeByCondition(CourseTypeQueryVo courseTypeQueryVo) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("测试查询条件");
        logger.debug("条件查询" + courseTypeQueryVo.toString());
        try {
            List<CourseType> courseTypeList = courseTypeService.findCourseTypeByCondition(courseTypeQueryVo);
            modelAndView.addObject("courseTypeList", courseTypeList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        modelAndView.setViewName("/coursetype/listCourse");
        return modelAndView;
    }

    @RequestMapping("/addCourseType")
    public ModelAndView addCourseType(@Validated CourseType courseType, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrorList = bindingResult.getAllErrors();
            for (ObjectError error : allErrorList) {
                logger.debug("课程错误校验" + error.getDefaultMessage());
            }

            modelAndView.addObject("allErrorList", allErrorList);
            modelAndView.setViewName("/coursetype/addCourse");
            return modelAndView;
        }
        try {
            courseTypeService.addCourseType(courseType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findAllCourseType();
    }
    @RequestMapping("/editCourseTypeBeforeUpdate")
    public ModelAndView editCourseTypeBeforeUpdate(CourseTypeQueryVo courseTypeQueryVo) {
        ModelAndView modelAndView = new ModelAndView();
        logger.debug("查找课程id" + courseTypeQueryVo.getCourseType().getCourseTypeId());
        try {
            List<CourseType> courseTypeList = courseTypeService.findCourseTypeByCondition(courseTypeQueryVo);
            modelAndView.addObject("courseType", courseTypeList.get(0));
            logger.debug("修改课程" + courseTypeList.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/coursetype/editCourse");
        return modelAndView;
    }
    @RequestMapping("/updateCourseType")
    public ModelAndView updateCourseType(CourseType courseType) {
        logger.debug("更新课程" + courseType.toString());
        try {
            courseTypeService.updateCourseType(courseType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return findAllCourseType();
    }


}
