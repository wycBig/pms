package com.ujiuye.usual.bean;

import com.ujiuye.sys.bean.Employee;

import java.util.Date;

public class BaoXiao {
    private String bxid;

    private String paymode;

    private Double totalmoney;

    private Date bxtime;

    private String bxremark;

    private Integer bxstatus;

    private Integer empFk;

    private String result;

   private Employee employee;

    public String getBxid() {
        return bxid;
    }

    public void setBxid(String bxid) {
        this.bxid = bxid;
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Date getBxtime() {
        return bxtime;
    }

    public void setBxtime(Date bxtime) {
        this.bxtime = bxtime;
    }

    public String getBxremark() {
        return bxremark;
    }

    public void setBxremark(String bxremark) {
        this.bxremark = bxremark;
    }

    public Integer getBxstatus() {
        return bxstatus;
    }

    public void setBxstatus(Integer bxstatus) {
        this.bxstatus = bxstatus;
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public BaoXiao(){
        super();
    }

    @Override
    public String toString() {
        return "BaoXiao{" +
                "bxid='" + bxid + '\'' +
                ", paymode='" + paymode + '\'' +
                ", totalmoney=" + totalmoney +
                ", bxtime=" + bxtime +
                ", bxremark='" + bxremark + '\'' +
                ", bxstatus=" + bxstatus +
                ", empFk=" + empFk +
                ", result='" + result + '\'' +
                ", employee=" + employee +
                '}';
    }

    public BaoXiao(String bxid, String paymode, Double totalmoney, Date bxtime, String bxremark, Integer bxstatus, Integer empFk, String result, Employee employee) {
        this.bxid = bxid;
        this.paymode = paymode;
        this.totalmoney = totalmoney;
        this.bxtime = bxtime;
        this.bxremark = bxremark;
        this.bxstatus = bxstatus;
        this.empFk = empFk;
        this.result = result;
        this.employee = employee;
    }
}