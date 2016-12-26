package com.sh.crm.hr.service;

import com.sh.crm.hr.po.Department;
import com.sh.crm.hr.utils.PageBeanUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface DepartmentService {


    /**
     * 分页查找所有的部门
     * @param currentPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    public PageBeanUtil<Department> findAllDepartment(int currentPage, int pageSize) throws Exception;

    /**
     * 查找所有的部门信息
     * @return
     * @throws Exception
     */
    public List<Department> findAllDepartment() throws Exception;

    public int findAllCountDepartment() throws Exception;

    public void addDepartment(Department department) throws Exception;

    public Department findDepartmentById(String depId) throws Exception;

    public void updateDepartment(Department department) throws Exception;

    public void deleteDepartment(String depId) throws Exception;
}
