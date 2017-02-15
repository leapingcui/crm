package com.sh.crm.student.service;

import com.sh.crm.student.po.Student;
import com.sh.crm.student.po.StudentVO;
import com.sh.crm.utils.PageBeanUtil;

/**
 * Created by Administrator on 2017/1/16.
 */
public interface StudentService {

    public PageBeanUtil<Student> findStudentByCondition(StudentVO studentVO) throws Exception;

    public void addStudent(Student student) throws Exception;

    public void updateStudent(Student student) throws Exception;

}
