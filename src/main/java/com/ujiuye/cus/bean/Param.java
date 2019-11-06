package com.ujiuye.cus.bean;

public class Param {
    private Integer cid;
    private String keyword;
    private Integer orderby;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public Param() {
        super();
    }

    public Param(Integer cid, String keyword, Integer orderby) {
        this.cid = cid;
        this.keyword = keyword;
        this.orderby = orderby;
    }

    @Override
    public String toString() {
        return "Param{" +
                "cid=" + cid +
                ", keyword='" + keyword + '\'' +
                ", orderby=" + orderby +
                '}';
    }
}
