package com.sh.crm.classes.service.impl;

import com.sh.crm.classes.mapper.CourseTypeMapper;
import com.sh.crm.classes.po.CourseType;
import com.sh.crm.classes.po.CourseTypeQueryVo;
import com.sh.crm.classes.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/12/26.
 */
@Service("courseTypeService")
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    private CourseTypeMapper courseTypeMapper;
    @Override
    public List<CourseType> findCourseTypeByCondition(CourseTypeQueryVo courseTypeQueryVo) throws Exception {
        return courseTypeMapper.findCourseTypeByCondition(courseTypeQueryVo);

    }

    @Override
    public void addCourseType(CourseType courseType) throws Exception {
        courseType.setCourseTypeId(UUID.randomUUID().toString());
        courseTypeMapper.addCourseType(courseType);

    }

    @Override
    public void updateCourseType(CourseType courseType) throws Exception {
        courseTypeMapper.updateCourseType(courseType);
    }
}
