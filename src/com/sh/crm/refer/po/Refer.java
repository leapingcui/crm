package com.sh.crm.refer.po;

import com.sh.crm.classes.po.Classes;
import com.sh.crm.classes.po.CourseType;
import com.sh.crm.hr.po.Staff;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by Administrator on 2017/1/11.
 */
public class Refer {

    //一个咨询的学生对应一个意向的课程类别和一个班级和一个管理员

    private String referId;
    @NotEmpty(message = "{refer.name.is.null}")
    private String name;
    @NotEmpty(message = "{refer.telephone.is.null}")
    private String telephone;
    private String QQ;
    private Date createDate;
    private String intentionLevel;
    private String source;
    private String status;
    private String remark;

    private CourseType courseType;
    private Classes classes;
    private Staff staff;

    public String getReferId() {
        return referId;
    }

    public void setReferId(String referId) {
        this.referId = referId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIntentionLevel() {
        return intentionLevel;
    }

    public void setIntentionLevel(String intentionLevel) {
        this.intentionLevel = intentionLevel;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Refer{" +
                "referId='" + referId + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", QQ='" + QQ + '\'' +
                ", createDate=" + createDate +
                ", intentionLevel='" + intentionLevel + '\'' +
                ", source='" + source + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", courseType=" + courseType +
                ", classes=" + classes +
                ", staff=" + staff +
                '}';
    }
}
