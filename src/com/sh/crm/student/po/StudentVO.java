package com.sh.crm.student.po;

/**
 * Created by Administrator on 2017/1/17.
 */
public class StudentVO {
    private Student student;
    private String condition;//查询条件
    private int currentPage = 1;//当前页
    private int pageIndex;//查询页面索引
    private int pageSize;//查询每页的数量

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "student=" + student +
                ", condition='" + condition + '\'' +
                ", currentPage='" + currentPage + '\'' +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }
}
