package com.sh.crm.classes.mapper;

import com.sh.crm.classes.po.Classes;
import com.sh.crm.classes.po.CourseType;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 * 班级的mapper接口
 */
public interface ClassesMapper {

    public List<Classes> findClassesByCondition(Classes classes) throws Exception;

    public void addClasses(Classes classes) throws Exception;

    public void updateClasses(Classes classes) throws Exception;

}
