package com.sh.crm.classes.po;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/26.
 * 班级的pojo对象
 * 对应数据库里面的crm_class表
 * 一个班级对应一个课：班级和课程是1对1的关系
 */
public class Classes {
    /**
     * CREATE TABLE `crm_class` (
     `classId` VARCHAR(50) NOT NULL PRIMARY KEY,
     `courseTypeId` VARCHAR(255) DEFAULT NULL,
     `className` VARCHAR(50) DEFAULT NULL,
     `beginTime` DATETIME DEFAULT NULL,
     `endTime` DATETIME DEFAULT NULL,
     `status` VARCHAR(20) DEFAULT NULL,
     `totalCount` INT(11) DEFAULT NULL,
     `upgradeCount` INT(11) DEFAULT NULL,
     `changeCount` INT(11) DEFAULT NULL,
     `runoffCount` INT(11) DEFAULT NULL,
     `remark` VARCHAR(500) DEFAULT NULL,
     `uploadTime` DATETIME DEFAULT NULL,
     `uploadPath` VARCHAR(200) DEFAULT NULL,
     `uploadFilename` VARCHAR(100) DEFAULT NULL,
     CONSTRAINT FOREIGN KEY (`courseTypeId`) REFERENCES `crm_course_type` (`courseTypeId`)
     ) ;
     */
    private String classId;
    private String className;
    private Date beginTime;
    private Date endTime;
    private String status;
    private int totalCount;
    private int upgradeCount;
    private int changeCount;
    private int runoffCount;
    private String remark;
    private Date uploadTime;
    private String uploadPath;
    private String uploadFilename;
    private CourseType courseType;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public int getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }

    public int getRunoffCount() {
        return runoffCount;
    }

    public void setRunoffCount(int runoffCount) {
        this.runoffCount = runoffCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadFilename() {
        return uploadFilename;
    }

    public void setUploadFilename(String uploadFilename) {
        this.uploadFilename = uploadFilename;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", totalCount=" + totalCount +
                ", upgradeCount=" + upgradeCount +
                ", changeCount=" + changeCount +
                ", runoffCount=" + runoffCount +
                ", remark='" + remark + '\'' +
                ", uploadTime=" + uploadTime +
                ", uploadPath='" + uploadPath + '\'' +
                ", uploadFilename='" + uploadFilename + '\'' +
                ", courseType=" + courseType +
                '}';
    }
}
