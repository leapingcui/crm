package com.sh.crm.refer.controller;

import com.sh.crm.classes.po.CourseType;
import com.sh.crm.classes.service.ClassesService;
import com.sh.crm.classes.service.CourseTypeService;
import com.sh.crm.refer.po.Refer;
import com.sh.crm.refer.po.ReferCondition;
import com.sh.crm.refer.service.ReferService;
import com.sh.crm.student.po.Student;
import com.sh.crm.student.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/1/11.
 */
@Controller
public class ReferController {

    private static final Logger logger = Logger.getLogger(ReferController.class);
    @Autowired
    private ReferService referService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseTypeService courseTypeService;

    @Autowired
    private ClassesService classesService;
    @RequestMapping("/findAllRefer")
    public ModelAndView findAllRefer() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Refer> referList = referService.findReferByCondition(null);
            logger.debug("所有咨询学生" + referList);
            modelAndView.addObject("referList", referList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/refer/listRefer");
        return modelAndView;
    }

    @RequestMapping("/findReferByCondition")
    public ModelAndView findReferByCondition(ReferCondition referCondition) {
        ModelAndView modelAndView = new ModelAndView();
        logger.debug("条件测试" + referCondition.toString());
        try {
            List<Refer> referList = referService.findReferByConditions(referCondition);
            logger.debug("条件查询咨询学生" + referList);
            modelAndView.addObject("referList", referList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/refer/listRefer");
        return modelAndView;
    }

    @RequestMapping("/addRefer")
    public ModelAndView addRefer(@Validated Refer refer, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        logger.debug("添加咨询学生：" + refer.toString());
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            for (ObjectError error : errorList) {
                logger.debug("添加咨询学生表单校验信息" + error.getDefaultMessage());
            }
            modelAndView.addObject("errorList", errorList);
            modelAndView.setViewName("/refer/addRefer");
            return modelAndView;

        }
        try {
            referService.addRefer(refer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findAllRefer();
    }

    @RequestMapping("/editBeforeAddRefer")
    public ModelAndView editBeforeAddRefer() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<CourseType> courseTypeList = courseTypeService.findCourseTypeByCondition(null);
            modelAndView.addObject("courseTypeList", courseTypeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/refer/addRefer");
        return modelAndView;
    }
    @RequestMapping("/updateRefer")
    public ModelAndView updateRefer(Refer refer) {
        logger.debug("更新咨询学生信息" + refer.toString());
        try {
            referService.updateRefer(refer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return findAllRefer();
    }

    /**
     * 更新咨询学生前
     * 1、根据咨询学生id查找学生信息
     * 2、使用ajax查找课程和班级
     * @param refer
     * @return
     */
    @RequestMapping("/editBeforeUpdateRefer")
    public ModelAndView editBeforeUpdateRefer(Refer refer) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Refer> referList = referService.findReferByCondition(refer);
            Refer resultRefer = referList.get(0);
            logger.debug("根据id查找咨询学生" + resultRefer.toString());
            modelAndView.addObject("refer", resultRefer);
            List<CourseType> courseTypeList = courseTypeService.findCourseTypeByCondition(null);
            modelAndView.addObject("courseTypeList", courseTypeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/refer/editRefer");
        return modelAndView;
    }

    /**
     * 根据id查询咨询学生详情，
     * @param refer
     * @return
     */
    @RequestMapping("/queryRefer")
    public ModelAndView queryRefer(Refer refer) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Refer> referList = referService.findReferByCondition(refer);
            Refer resultResult = referList.get(0);
            logger.debug("查看咨询学生" + resultResult.toString());
            modelAndView.addObject("refer", resultResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/refer/showRefer");
        return modelAndView;
    }

    /**
     * 录入学籍
     * @param student
     * @return
     */
    @RequestMapping("/entryStatus")
    public ModelAndView entryStatus(@Validated Student student, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                logger.debug("录入学籍校验" + error.getDefaultMessage());
            }
            modelAndView.addObject("errors", errors);
            modelAndView.setViewName("/refer/addStudent");
            return modelAndView;

        }
        Refer refer = null;
        try {
            refer = referService.findReferByCondition(student.getRefer()).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        student.setStudentId(UUID.randomUUID().toString());
        student.setAdmissionDate(new Date());
        student.setStatus("新生");
        student.setRefer(refer);
        student.setClasses(student.getRefer().getClasses());
        student.setCourseType(student.getRefer().getCourseType());
        try {
            studentService.addStudent(student);

            refer.setStatus("已报名");
            referService.updateRefer(refer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return findAllRefer();
    }

    /**
     * 根据id查找咨询学生信息，
     * @param refer
     * @return
     */
    @RequestMapping("/editBeforeEntryStatus")
    public ModelAndView editBeforeEntryStatus(Refer refer) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Refer> referList = referService.findReferByCondition(refer);
            Refer resultRefer = referList.get(0);
            modelAndView.addObject("refer", resultRefer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/refer/addStudent");
        return modelAndView;
    }

}
