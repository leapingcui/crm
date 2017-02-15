package com.sh.crm.hr.controller;

import com.sh.crm.hr.service.DepartmentService;
import com.sh.crm.hr.po.Department;
import com.sh.crm.utils.PageBeanUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by Administrator on 2016/12/19.
 */
@Controller
public class DepartmentController {
    private static Logger logger = Logger.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping("/findAllDepartment.action")
    public ModelAndView findAllDepartment(int currentPage) {

        ModelAndView modelAndView = new ModelAndView();
        try {
            PageBeanUtil<Department> pageBeanUtil = departmentService.findAllDepartment(currentPage);
            modelAndView.addObject("pageBeanUtil", pageBeanUtil);
        } catch (Exception e) {
            e.printStackTrace();
        }

        modelAndView.setViewName("/department/listDepartment");
        return modelAndView;
    }

    @RequestMapping("/addDepartment.action")
    public ModelAndView addDepartment(HttpServletRequest request, Department department) {
        logger.debug(department.getDepName());
        String depId = UUID.randomUUID().toString();
        department.setDepId(depId);
        try {
            departmentService.addDepartment(department);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return findAllDepartment(PageBeanUtil.CURRENT_PAGE);
    }

    @RequestMapping("/editDepartmentBeforeUpdate.action")
    public ModelAndView editDepartmentBeforeUpdate(String depId) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            logger.debug("edit-depId-->");
            Department department = departmentService.findDepartmentById(depId);
            logger.debug("edit-department->" + department);
            modelAndView.addObject("department", department);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/department/editDepartment");
        return modelAndView;
    }

    @RequestMapping("/updateDepartment.action")
    public ModelAndView updateDepartment( Department department) {

        try {
            departmentService.updateDepartment(department);

        } catch (Exception e) {
            e.printStackTrace();
        }
       return findAllDepartment(PageBeanUtil.CURRENT_PAGE);
    }
}
