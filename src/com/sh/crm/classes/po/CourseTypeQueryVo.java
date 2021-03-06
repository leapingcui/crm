package com.sh.crm.classes.po;

/**
 * Created by Administrator on 2016/12/26.
 */
public class CourseTypeQueryVo {

    private CourseType courseType;
    private int startHour = 0; //起始查询学时
    private int endHour = 0; //终止查询学时
    private double startCost = 0; //起始查询课程费用
    private double endCost = 0; //终止查询课程费用

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public double getStartCost() {
        return startCost;
    }

    public void setStartCost(double startCost) {
        this.startCost = startCost;
    }

    public double getEndCost() {
        return endCost;
    }

    public void setEndCost(double endCost) {
        this.endCost = endCost;
    }

    @Override
    public String toString() {
        return "CourseTypeQueryVo{" +
                "courseType=" + courseType +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                ", startCost=" + startCost +
                ", endCost=" + endCost +
                '}';
    }
}
