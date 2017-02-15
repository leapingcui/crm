package com.sh.crm.student.po;

import com.sh.crm.classes.po.Classes;
import com.sh.crm.classes.po.CourseType;
import com.sh.crm.refer.po.Refer;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by Administrator on 2017/1/16.
 */
public class Student {

    private String studentId;
    @NotEmpty(message = "{student.name.is.null}")
    private String name;
    @NotEmpty(message = "{student.telephone.is.null}")
    private String telephone;
    @NotEmpty(message = "{student.identity.is.null}")
    private String identity;
    private String QQ;
    private Date admissionDate;
    private String gender;
    private int mustTuition;
    private int actualTuition;
    private String email;
    private String school;
    private String education;
    private String professional;
    private String identityAddress;
    private String address;
    private String remark;
    private String homeTelephone;
    private String homeContact;
    private String status;
    //一个学生对应一个课程，一个班级，一个咨询咨询学生
    private CourseType courseType;
    private Classes classes;
    private Refer refer;

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMustTuition() {
        return mustTuition;
    }

    public void setMustTuition(int mustTuition) {
        this.mustTuition = mustTuition;
    }

    public int getActualTuition() {
        return actualTuition;
    }

    public void setActualTuition(int actualTuition) {
        this.actualTuition = actualTuition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getIdentityAddress() {
        return identityAddress;
    }

    public void setIdentityAddress(String identityAddress) {
        this.identityAddress = identityAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHomeTelephone() {
        return homeTelephone;
    }

    public void setHomeTelephone(String homeTelephone) {
        this.homeTelephone = homeTelephone;
    }

    public String getHomeContact() {
        return homeContact;
    }

    public void setHomeContact(String homeContact) {
        this.homeContact = homeContact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Refer getRefer() {
        return refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", identity='" + identity + '\'' +
                ", QQ='" + QQ + '\'' +
                ", admissionDate='" + admissionDate + '\'' +
                ", gender='" + gender + '\'' +
                ", mustTuition=" + mustTuition +
                ", actualTuition=" + actualTuition +
                ", email='" + email + '\'' +
                ", school='" + school + '\'' +
                ", education='" + education + '\'' +
                ", professional='" + professional + '\'' +
                ", identityAddress='" + identityAddress + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", homeTelephone='" + homeTelephone + '\'' +
                ", homeContact='" + homeContact + '\'' +
                ", status='" + status + '\'' +
                ", courseType=" + courseType +
                ", classes=" + classes +
                ", refer=" + refer +
                '}';
    }
}
