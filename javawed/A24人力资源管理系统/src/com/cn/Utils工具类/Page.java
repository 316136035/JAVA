package com.cn.Utils工具类;

import java.util.List;

public class Page <T>{

    public Page() {

    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public long getTotaConunt() {
        return totaConunt;
    }

    public void setTotaConunt(long totaConunt) {
        this.totaConunt = (int) totaConunt;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }


    @Override
    public String toString() {
        return "Page{" +
                "pageCode=" + pageCode +
                ", pageSize=" + pageSize +
                ", totaConunt=" + totaConunt +
                ", beanList=" + beanList +
                '}';
    }

    //当前页面编号
    private  int pageCode;


    // 每页显示的数据条数
    private  int pageSize;

    //数据库总记录数
    private int totaConunt;


    //每一页显示的数据
    private List<T> beanList;


    /**获取总页数totalPage也是属性*/
    public int getTotalPage(int Conunt) {
        // 做计算，计算的结果直接返回给你
        int tp =  ( Conunt / this.pageSize);
        // 说明整除，
        if(  Conunt% this.pageSize == 0){
            return tp;
        }else{
            return tp+1;
        }
    }

    public Page(int pageCode, int pageSize, long totaConunt, List<T> beanList) {
        this.pageCode = pageCode;
        this.pageSize = pageSize;
        this.totaConunt = (int) totaConunt;
        this.beanList = beanList;
    }
}
