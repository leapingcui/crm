package com.sh.crm.classes.mapper;

import com.sh.crm.classes.po.CourseType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/12/26.
 */
public class CourseTypeMapperTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp() throws Exception {
        String path = "applicationContext.xml";
        applicationContext = new ClassPathXmlApplicationContext(path);
    }

    @Test
    public void findCourseTypeByCondition() throws Exception {
        CourseTypeMapper courseTypeMapper = (CourseTypeMapper) applicationContext.getBean("courseTypeMapper");
        List<CourseType> courseTypeList = courseTypeMapper.findCourseTypeByCondition(null);
        System.out.println(courseTypeList);


    }
    @Test
    public void addCourseType() throws Exception {
        CourseTypeMapper courseTypeMapper = (CourseTypeMapper) applicationContext.getBean("courseTypeMapper");
        CourseType courseType = new CourseType();
        courseType.setCourseTypeId("fsdf");
        courseType.setCourseCost(1000);
        courseType.setCourseName("python");
        courseType.setRemark("python测试");
        courseTypeMapper.addCourseType(courseType);


    }

}