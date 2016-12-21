package com.sh.crm.service;

import com.sh.crm.po.Department;
import com.sh.crm.utils.PageBeanUtil;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface DepartmentService {



    public PageBeanUtil<Department> findAllDepartment(int currentPage, int pageSize) throws Exception;

    public int findAllCountDepartment() throws Exception;

    public void addDepartment(Department department) throws Exception;

    public Department findDepartmentById(String depId) throws Exception;

    public void updateDepartment(Department department) throws Exception;

    public void deleteDepartment(String depId) throws Exception;
}
