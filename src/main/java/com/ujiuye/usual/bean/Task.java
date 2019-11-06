package com.ujiuye.usual.bean;

import com.ujiuye.sys.bean.Employee;

import java.util.Date;

public class Task {
    private Integer id;

    private Date starttime;

    private Date endtime;

    private String level;

    private String remark;

    private Integer funFk;

    private Integer empFk2;

    private Integer empFk;

    private String tasktitle;

    private Integer status;
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getFunFk() {
        return funFk;
    }

    public void setFunFk(Integer funFk) {
        this.funFk = funFk;
    }

    public Integer getEmpFk2() {
        return empFk2;
    }

    public void setEmpFk2(Integer empFk2) {
        this.empFk2 = empFk2;
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }

    public String getTasktitle() {
        return tasktitle;
    }

    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", level='" + level + '\'' +
                ", remark='" + remark + '\'' +
                ", funFk=" + funFk +
                ", empFk2=" + empFk2 +
                ", empFk=" + empFk +
                ", tasktitle='" + tasktitle + '\'' +
                ", status=" + status +
                ", employee=" + employee +
                '}';
    }

    public Task(Integer id, Date starttime, Date endtime, String level, String remark, Integer funFk, Integer empFk2, Integer empFk, String tasktitle, Integer status, Employee employee) {
        this.id = id;
        this.starttime = starttime;
        this.endtime = endtime;
        this.level = level;
        this.remark = remark;
        this.funFk = funFk;
        this.empFk2 = empFk2;
        this.empFk = empFk;
        this.tasktitle = tasktitle;
        this.status = status;
        this.employee = employee;
    }
    public Task(){
        super();
    }
}