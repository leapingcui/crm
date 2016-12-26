package com.sh.crm.classes.mapper;

import com.sh.crm.classes.po.CourseType;
import com.sh.crm.classes.po.CourseTypeQueryVo;

import java.util.List;

/**
 * Created by Administrator on 2016/12/26.
 * 课程类型mapper，包括增删改查
 *
 *
 */
public interface CourseTypeMapper {
    //条件查询
    public List<CourseType> findCourseTypeByCondition(CourseTypeQueryVo courseTypeQueryVo) throws Exception;
    //添加课程
    public void addCourseType(CourseType courseType) throws Exception;
    //更新课程
    public void updateCourseType(CourseType courseType) throws Exception;

}
