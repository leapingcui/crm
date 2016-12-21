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
     *
     * @return
     * @throws Exception
     */
    public List<Department> findAllDepartment(HashMap<String, Integer> hashMap) throws Exception;

    public int findAllCountDepartment() throws Exception;

    public void addDepartment(Department department) throws Exception;

    public Department findDepartmentById(String depId) throws Exception;

    public void updateDepartment(Department department) throws Exception;

    public void deleteDepartment(String depId) throws Exception;
}
