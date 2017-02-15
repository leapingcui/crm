package com.sh.crm.student.controller;

import com.sh.crm.classes.po.CourseType;
import com.sh.crm.classes.service.CourseTypeService;
import com.sh.crm.student.po.Student;
import com.sh.crm.student.po.StudentVO;
import com.sh.crm.student.service.StudentService;
import com.sh.crm.utils.PageBeanUtil;
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
 * Created by Administrator on 2017/1/16.
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseTypeService courseTypeService;
    private static final Logger logger = Logger.getLogger(StudentController.class);
    /**
     * 条件查询学生信息，并分页显示
     *  1、将条件封装到StudentVO对象中
     *  2、查询所有的课程
     * @param studentVO
     * @return
     */
    @RequestMapping("/findStudentByCondition")
    public ModelAndView findStudentByCondition(StudentVO studentVO) {
        ModelAndView modelAndView = new ModelAndView();
        String condition = null;
        if (studentVO != null) {
            condition = studentVO.getCondition();
        }

        if (condition != null && condition.trim().length() != 0) {
            studentVO.setCondition(condition);
            modelAndView.addObject("condition", condition);
        }

        try {
            PageBeanUtil<Student> studentPageBeanUtil = studentService.findStudentByCondition(studentVO);
            List<CourseType> courseTypeList = courseTypeService.findCourseTypeByCondition(null);
            modelAndView.addObject("courseTypeList", courseTypeList);
            modelAndView.addObject("studentPageBean", studentPageBeanUtil);
        } catch (Exception e) {
            e.printStackTrace();
        }


        modelAndView.setViewName("/student/listStudent");
        return modelAndView;
    }

    @RequestMapping("/addStudent")
    public ModelAndView addStudent(@Validated Student student, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        StudentVO studentVO = new StudentVO();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                logger.debug("添加学生表单校验" + error.getDefaultMessage());
            }
            modelAndView.addObject("errors", errors);
            modelAndView.setViewName("/student/addStudent");
            return modelAndView;

        }
        try {
            studentService.addStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findStudentByCondition(studentVO);
    }

    @RequestMapping("/editBeforeAddStudent")
    public ModelAndView editBeforeAddStudent() {
        ModelAndView modelAndView = new ModelAndView();
        List<CourseType> courseTypeList = null;
        try {

            courseTypeList = courseTypeService.findCourseTypeByCondition(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("courseTypeList", courseTypeList);
        modelAndView.setViewName("/student/addStudent");
        return modelAndView;
    }

    @RequestMapping("/showStudent")
    public ModelAndView showStudent(Student student) {
        ModelAndView modelAndView = new ModelAndView();
        StudentVO studentVO = new StudentVO();
        studentVO.setStudent(student);
        try {
            PageBeanUtil<Student> studentPageBeanUtil =  studentService.findStudentByCondition(studentVO);
            List<Student> studentList = studentPageBeanUtil.getPageBean();
            Student resultStudent = studentList.get(0);
            modelAndView.addObject("student", resultStudent);
            modelAndView.setViewName("/student/showStudent");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
