package com.sh.crm.classes.po;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/26.
 * 对应数据库里面的crm_course_type
 * 一个课程可以有多个班级：课程对班级是1对多关系
 */
public class CourseType {
    /**
     * CREATE TABLE `crm_course_type` (
     `courseTypeId` VARCHAR(255) NOT NULL PRIMARY KEY,
     `courseCost` DOUBLE DEFAULT NULL,
     `totalHour` INT(11) DEFAULT NULL,
     `courseName` VARCHAR(500) DEFAULT NULL,
     `remark` VARCHAR(5000) DEFAULT NULL
     );
     */
    private String courseTypeId;
    @NotNull(message = "{courseType.courseCost.isNull}")
    private double courseCost;
    @NotNull(message = "{courseType.costHour.isNull}")
    private int totalHour;
    @NotEmpty(message = "{courseType.courseName.isNull}")
    private String courseName;
    private String remark;
    private Set<Classes> classesSet = new HashSet<Classes>();

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(double courseCost) {
        this.courseCost = courseCost;
    }

    public int getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(int totalHour) {
        this.totalHour = totalHour;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<Classes> getClassesSet() {
        return classesSet;
    }

    public void setClassesSet(Set<Classes> classesSet) {
        this.classesSet = classesSet;
    }

    @Override
    public String toString() {
        return "CourseType{" +
                "courseTypeId='" + courseTypeId + '\'' +
                ", courseCost='" + courseCost + '\'' +
                ", totalHour=" + totalHour +
                ", courseName='" + courseName + '\'' +
                ", remark='" + remark + '\'' +
                ", classesSet=" + classesSet +
                '}';
    }
}
