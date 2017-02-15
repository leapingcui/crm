package com.sh.crm.student.mapper;

import com.sh.crm.student.po.Student;
import com.sh.crm.student.po.StudentVO;
import com.sh.crm.utils.PageBeanUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */
public interface StudentMapper {

    public List<Student> findStudentByCondition(StudentVO studentVO) throws Exception;

    public int findStudentCountByCondition(StudentVO studentVO) throws Exception;

    public void addStudent(Student student) throws Exception;

    public void updateStudent(Student student) throws Exception;
}
