package com.sh.crm.student.po;

import com.sh.crm.hr.po.Staff;

import java.util.Date;

/**
 * Created by Administrator on 2017/1/16.
 */
public class RunOff {

    private String runOffId;
    private Date createDate;
    private String isRefund;
    private String refundAmount;
    private String remark;

    //一个流失学生对应一个学生，对应一个经办人
    private Student student;
    private Staff staff;

    public String getRunOffId() {
        return runOffId;
    }

    public void setRunOffId(String runOffId) {
        this.runOffId = runOffId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(String isRefund) {
        this.isRefund = isRefund;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    @Override
    public String toString() {
        return "RunOff{" +
                "runOffId='" + runOffId + '\'' +
                ", createDate=" + createDate +
                ", isRefund='" + isRefund + '\'' +
                ", refundAmount='" + refundAmount + '\'' +
                ", remark='" + remark + '\'' +
                ", student=" + student +
                ", staff=" + staff +
                '}';
    }
}
