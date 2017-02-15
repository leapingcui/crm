package com.sh.crm.hr.service.impl;

import com.sh.crm.hr.mapper.DepartmentMapper;
import com.sh.crm.hr.po.Department;
import com.sh.crm.hr.service.DepartmentService;
import com.sh.crm.utils.PageBeanUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    private static Logger logger = Logger.getLogger(DepartmentServiceImpl.class);
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public int findAllCountDepartment() throws Exception {
        return departmentMapper.findAllCountDepartment();
    }

    @Override
    public List<Department> findAllDepartment() throws Exception {
        return departmentMapper.findAllDepartment();
    }

    /**
     * 分页处理的业务逻辑
     * @param currentPage
     * @return
     * @throws Exception
     */
    @Override
    public PageBeanUtil<Department> findAllDepartment(int currentPage) throws Exception {
        //查询所有部门的条数
        int totalNum = departmentMapper.findAllCountDepartment();

        PageBeanUtil<Department> pageBeanUtil = new PageBeanUtil<>(currentPage, totalNum);
        //封装查询条件到hashMap，查找所有的部门
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("pageIndex", pageBeanUtil.getPageIndex());
        hashMap.put("pageSize", pageBeanUtil.getPageSize());
        List<Department> departmentList = departmentMapper.findAllDepartmentPage(hashMap);
        pageBeanUtil.setPageBean(departmentList);

        return pageBeanUtil;
    }

    @Override
    public void addDepartment(Department department) throws Exception {
        departmentMapper.addDepartment(department);
    }

    @Override
    public Department findDepartmentById(String depId) throws Exception {
        return departmentMapper.findDepartmentById(depId);
    }

    @Override
    public void updateDepartment(Department department) throws Exception {
        departmentMapper.updateDepartment(department);

    }

    @Override
    public void deleteDepartment(String depId) throws Exception {
        departmentMapper.deleteDepartment(depId);

    }
}
