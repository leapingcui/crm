package com.sh.crm.staff.po;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/17.
 */
public class Staff {
    /*
    * CREATE TABLE `crm_staff` (
          `staffId` VARCHAR(255) NOT NULL PRIMARY KEY,
          `loginName` VARCHAR(100) DEFAULT NULL,
          `loginPwd` VARCHAR(100) DEFAULT NULL,
          `staffName` VARCHAR(100) DEFAULT NULL,
          `gender` VARCHAR(20) DEFAULT NULL,
          `onDutyDate` DATETIME DEFAULT NULL,
          `postId` VARCHAR(255) DEFAULT NULL,
          CONSTRAINT FOREIGN KEY (`postId`) REFERENCES `crm_post` (`postId`)
        );
        根据数据库的员工表创建对应的bean对象
    * */
    private String staffId;
    private String loginName;
    private String loginPwd;
    private String staffName;
    private String gender;
    private Date onDutyDate;
    private String postId;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Date onDutyDate) {
        this.onDutyDate = onDutyDate;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId='" + staffId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", staffName='" + staffName + '\'' +
                ", gender='" + gender + '\'' +
                ", onDutyDate=" + onDutyDate +
                ", postId='" + postId + '\'' +
                '}';
    }
}
