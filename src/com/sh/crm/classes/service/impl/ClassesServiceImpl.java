package com.sh.crm.classes.service.impl;

import com.sh.crm.classes.mapper.ClassesMapper;
import com.sh.crm.classes.po.Classes;
import com.sh.crm.classes.service.ClassesService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/12/28.
 */
@Service("classesService")
public class ClassesServiceImpl implements ClassesService {

    private static Logger logger = Logger.getLogger(ClassesServiceImpl.class);
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<Classes> findClassesByCondition(Classes classes) throws Exception {
        return classesMapper.findClassesByCondition(classes);
    }

    @Override
    public void addClasses(Classes classes) throws Exception {
        classes.setClassId(UUID.randomUUID().toString());
        Classes classesWithStatus = classesStatus(classes);
        classesMapper.addClasses(classesWithStatus);

    }

    @Override
    public void updateClasses(Classes classes) throws Exception {
        Classes classesWithStatus =  classesStatus(classes);
        classesMapper.updateClasses(classesWithStatus);

    }

    private Classes classesStatus(Classes classes) {
        Date currentDate = new Date();
        Date beginTime = classes.getBeginTime();
        Date endTime = classes.getEndTime();


        /**
         * 如果当前时间小于开课时间，则当前状态为未开课
         * 如果当前时间大于结课时间，则当前状态为已结课
         * 如果当前时间大于开课时间并且小于结课时间，则当前状态为已开课
         */
        if (currentDate.before(beginTime)) {
            classes.setStatus("未开课");
        } else if (currentDate.after(endTime)) {
            classes.setStatus("已结课");
        } else {
            classes.setStatus("已开课");
        }
        return classes;
    }
}
