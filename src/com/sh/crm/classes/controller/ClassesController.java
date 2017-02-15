package com.sh.crm.classes.controller;

import com.sh.crm.classes.po.Classes;
import com.sh.crm.classes.po.CourseType;
import com.sh.crm.classes.service.ClassesService;
import com.sh.crm.classes.service.CourseTypeService;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import java.util.UUID;

/**
 * Created by Administrator on 2016/12/28.
 * 班级控制器
 * 包括增加班级、编辑班级、查看班级、查找所有班级
 */
@Controller
public class ClassesController {


    @Autowired
    private ClassesService classesService;
    @Autowired
    private CourseTypeService courseTypeService;
    private static Logger logger = Logger.getLogger(ClassesController.class);

    @RequestMapping("/findAllClasses")
    public ModelAndView findAllClasses() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Classes> classesList = classesService.findClassesByCondition(null);
            modelAndView.addObject("classesList", classesList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/classesm/listClass");
        return modelAndView;
    }

    @RequestMapping("/lookClasses")
    public ModelAndView lookClasses(Classes classes) {
        ModelAndView modelAndView = new ModelAndView();

        return modelAndView;
    }

    /**
     * 在添加班级前，查找所有的课程
     * @return
     */
    @RequestMapping("/editClassBeforeAdd")
    public ModelAndView editClassesBeforeAdd() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<CourseType> courseTypeList = courseTypeService.findCourseTypeByCondition(null);
            modelAndView.addObject("courseTypeList", courseTypeList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        modelAndView.setViewName("/classesm/addClass");
        return modelAndView;
    }

    @RequestMapping("/addClasses")
    public ModelAndView addClasses(Classes classes) {
        try {
            classesService.addClasses(classes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findAllClasses();
    }

    /**
     * 编辑班级前，通过id查找对应的班级以及所有的课程
     * @param classes
     * @return
     */
    @RequestMapping("/editClassesBeforeUpdate")
    public ModelAndView editClassesBeforeUpdate(Classes classes) {
        ModelAndView modelAndView = new ModelAndView();
        List<Classes> classesList = null;
        List<CourseType> courseTypeList = null;
        try {
            classesList = classesService.findClassesByCondition(classes);
            courseTypeList = courseTypeService.findCourseTypeByCondition(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Classes resultClass = classesList.get(0);
        logger.debug("编辑班级返回的数据" + resultClass);
        modelAndView.addObject("classes", resultClass);
        modelAndView.addObject("courseTypeList", courseTypeList);
        modelAndView.setViewName("/classesm/editClass");
        return modelAndView;
    }

    @RequestMapping("/updateClasses")
    public ModelAndView updateClasses(Classes classes) {
        try {
            classesService.updateClasses(classes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findAllClasses();
    }

    /**
     * 显示班级详情
     * 1、通过id查找对应班级
     * 2、查找学生信息（待完善）
     * @param classes
     * @return
     */
    @RequestMapping("/showClasses")
    public ModelAndView showClasses(Classes classes) {
        ModelAndView modelAndView = new ModelAndView();
        List<Classes> classesList = null;
        try {
            classesList = classesService.findClassesByCondition(classes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Classes resultClass = classesList.get(0);
        modelAndView.addObject("classes", resultClass);
        modelAndView.setViewName("/classesm/showClass");

        return modelAndView;
    }

    /**(
     * 添加咨询学生时，需要根据课程类型查找所有对应的班级
     * @param classes
     * @return
     */
    @RequestMapping("/findClassesByCourseTypeId")
    public @ResponseBody List<Classes> findClassesByCourseTypeId(Classes classes) {
        List<Classes> classesList = null;
        try {
            logger.debug("根据课程id查找班级" + classes.toString());
            classesList = classesService.findClassesByCondition(classes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return classesList;
    }

    @RequestMapping("/beforeUpload")
    public ModelAndView beforeUpload(Classes classes) {
        ModelAndView modelAndView = new ModelAndView();
        try {

            List<Classes> classesList = classesService.findClassesByCondition(classes);
            modelAndView.addObject("classes", classesList.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/classesm/uploadClass");
        return modelAndView;
    }

    /**
     * 上传文件
     * 1、获取原始文件名
     * 2、获取需要保持的文件路径
     * 3、创建新的文件名
     * 4、创建文件准备上传
     * 5、讲内存数据写入磁盘
     * @param request
     * @param classes
     * @param schedule
     * @return
     */
    @RequestMapping("/uploadSchedule")
    public ModelAndView uploadSchedule(HttpServletRequest request, Classes classes, MultipartFile schedule) {

        String scheduleOriginalName = schedule.getOriginalFilename();
        String path = request.getServletContext().getRealPath("/upload");
        logger.debug("上传文件的路径" + path);
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        String scheduleNewName = UUID.randomUUID().toString() + "_" + scheduleOriginalName;
        logger.debug("上传文件的名称" + scheduleNewName);
        File newFile = new File(file, scheduleNewName);
        try {
            schedule.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        classes.setUploadTime(new Date());
        classes.setUploadPath(path);
        classes.setUploadFilename(scheduleNewName);
        try {
            classesService.updateClasses(classes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findAllClasses();
    }

    /**
     * 下载文件
     * 1、获取文件路径和名称,查找数据库
     * 2、设置文件类型
     * 3、设置响应头
     * 4、从输入流中读取文件
     * 5、将文件写入输出流
     * 6、关闭流
     *
     * @param response
     */
    @RequestMapping("/downloadSchedule")
    public void downloadSchedule(HttpServletResponse response, Classes classes) {
        Classes resultClasses = null;
        try {
            List<Classes> classesList = classesService.findClassesByCondition(classes);
            resultClasses = classesList.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //1、获取文件名称和路径
        String fileName = resultClasses.getUploadFilename();
        logger.debug("文件名称" + fileName);
        String filePath = resultClasses.getUploadPath();
        File file = new File(filePath + "/" + fileName);
        //2、设置类型
        String contentType = URLConnection.guessContentTypeFromName(fileName);
        response.setContentType(contentType);
        //3、设置响应头,注意处理编码问题
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //4、获取输入流
            inputStream = new BufferedInputStream(new FileInputStream(file));
            //5、获取输出流
            outputStream = response.getOutputStream();
            //6、将文件从输入流负责到输出流
            FileCopyUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
