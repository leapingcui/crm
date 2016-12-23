package com.sh.crm.mapper;

import com.sh.crm.po.Department;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface DepartmentMapper {
    /**
     *
     *查找所有的部门信息
     * @return
     * @throws Exception
     */
    public List<Department> findAllDepartmentPage(HashMap<String, Integer> hashMap) throws Exception;
    //查找所有部门信息
    public List<Department> findAllDepartment() throws Exception;


    public int findAllCountDepartment() throws Exception;

    public void addDepartment(Department department) throws Exception;

    public Department findDepartmentById(String depId) throws Exception;

    public void updateDepartment(Department department) throws Exception;

    public void deleteDepartment(String depId) throws Exception;
}
