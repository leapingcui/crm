package com.sh.crm.student.service.impl;

import com.sh.crm.student.mapper.StudentMapper;
import com.sh.crm.student.po.Student;
import com.sh.crm.student.po.StudentVO;
import com.sh.crm.student.service.StudentService;
import com.sh.crm.utils.PageBeanUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/1/16.
 */
@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = Logger.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageBeanUtil<Student> findStudentByCondition(StudentVO studentVO) throws Exception {
        String condition = studentVO.getCondition();

        if (condition != null && condition.trim().length() != 0) {
            Student student = studentVO.getStudent();
            if (student == null) {
                student = new Student();
            }
            student.setName(condition);
            student.setTelephone(condition);
            student.setQQ(condition);
            student.setGender(condition);
            studentVO.setStudent(student);
        }
        int currentPage = studentVO.getCurrentPage();
        int totalNum = studentMapper.findStudentCountByCondition(studentVO);
        PageBeanUtil<Student> studentPageBeanUtil = new PageBeanUtil<>(currentPage, totalNum);
        studentVO.setPageIndex(studentPageBeanUtil.getPageIndex());
        studentVO.setPageSize(studentPageBeanUtil.getPageSize());
        logger.debug("学生查询条件" + studentVO.toString());
        List<Student> studentList = studentMapper.findStudentByCondition(studentVO);
        studentPageBeanUtil.setPageBean(studentList);


        return studentPageBeanUtil;
    }

    @Override
    public void addStudent(Student student) throws Exception {
        student.setStudentId(UUID.randomUUID().toString());
        student.setAdmissionDate(new Date());
        student.setStatus("新生");
        studentMapper.addStudent(student);

    }

    @Override
    public void updateStudent(Student student) throws Exception {
        studentMapper.updateStudent(student);

    }
}
