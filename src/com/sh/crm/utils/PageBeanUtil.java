package com.sh.crm.utils;

import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */
public class PageBeanUtil<T> {
    public static final int PAGE_SIZE = 5;//每页的条数，固定值
    public static final int CURRENT_PAGE = 0;//当前页，默认值
    private int currentPage; //当前页
    private int pageSize; //每页的条数
    private int totalNum; //总条数
    private int totalPage; //总页数
    private int pageIndex; //每页的索引值

    private List<T> pageBean; //注入页面数据bean
    //动态显示页数,默认显示10页
    private int start;//开始页
    private int end;//结束页

    //创建PageUtil对象时必须传递的三个参数，其他两个可以通过计算得到
    public PageBeanUtil(int currentPage, int pageSize, int totalNum) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (totalNum + pageSize - 1) / pageSize;
        this.pageIndex = (currentPage - 1) * pageSize;
        //如果总页数小于十页，则最后一页为总页数,假设currentPage = 4;
        if(totalPage <= 10) {
            this.start = 1;
            this.end = this.totalPage;
        } else {
            //如果当前页为22，使用前四后五显示
            this.start = this.currentPage - 4;
            this.end = this.currentPage + 5;
            if (this.start < 1) {
                this.start = 1;
                this.end = 10;
            }
            if (this.end > this.totalPage) {
                this.start = this.totalPage - 9;
                this.end = this.totalPage;
            }
        }

    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<T> getPageBean() {
        return pageBean;
    }

    public void setPageBean(List<T> pageBean) {
        this.pageBean = pageBean;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "PageBeanUtil{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalNum=" + totalNum +
                ", totalPage=" + totalPage +
                ", pageIndex=" + pageIndex +
                ", pageBean=" + pageBean +
                '}';
    }
}
