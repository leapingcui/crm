package com.sh.crm.classes.service;

import com.sh.crm.classes.po.Classes;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
public interface ClassesService {

    public List<Classes> findClassesByCondition(Classes classes) throws Exception ;

    public void addClasses(Classes classes) throws Exception;

    public void updateClasses(Classes classes) throws Exception;
}
