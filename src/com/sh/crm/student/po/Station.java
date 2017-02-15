package com.sh.crm.student.po;

import com.sh.crm.classes.po.Classes;
import com.sh.crm.classes.po.CourseType;
import com.sh.crm.hr.po.Staff;

import java.util.Date;

/**
 * Created by Administrator on 2017/1/16.
 */
public class Station {

    private String stationId;
    private String flag;
    private Date createDate;

    //一个转班状态对应于一个学生，一个经办人，一个之前的班级和课程，一个之后的班级和课程
    private Student student;
    private Staff staff;
    private CourseType beforeCourseType;
    private CourseType afterCourseType;
    private Classes beforeClasses;
    private Classes afterClasses;

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public CourseType getBeforeCourseType() {
        return beforeCourseType;
    }

    public void setBeforeCourseType(CourseType beforeCourseType) {
        this.beforeCourseType = beforeCourseType;
    }

    public CourseType getAfterCourseType() {
        return afterCourseType;
    }

    public void setAfterCourseType(CourseType afterCourseType) {
        this.afterCourseType = afterCourseType;
    }

    public Classes getBeforeClasses() {
        return beforeClasses;
    }

    public void setBeforeClasses(Classes beforeClasses) {
        this.beforeClasses = beforeClasses;
    }

    public Classes getAfterClasses() {
        return afterClasses;
    }

    public void setAfterClasses(Classes afterClasses) {
        this.afterClasses = afterClasses;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId='" + stationId + '\'' +
                ", flag='" + flag + '\'' +
                ", createDate=" + createDate +
                ", student=" + student +
                ", staff=" + staff +
                ", beforeCourseType=" + beforeCourseType +
                ", afterCourseType=" + afterCourseType +
                ", beforeClasses=" + beforeClasses +
                ", afterClasses=" + afterClasses +
                '}';
    }
}
