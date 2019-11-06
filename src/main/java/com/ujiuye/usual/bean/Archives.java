package com.ujiuye.usual.bean;

import com.ujiuye.sys.bean.Employee;

import java.util.Date;

public class Archives {
    private String dnum;

    private String landline;

    private String school;

    private String zhuanye;

    private String sosperson;

    private Date biyedate;

    private String zzmm;

    private String minzu;

    private String xueli;

    private String email;

    private Integer empFk;

    private String remark;

    private Date hirdate;

    private Employee employee;

    private Dept dept;

    private Position position;

    private  Level level;

    public Archives() {
        super();
    }

    @Override
    public String toString() {
        return "Archives{" +
                "dnum='" + dnum + '\'' +
                ", landline='" + landline + '\'' +
                ", school='" + school + '\'' +
                ", zhuanye='" + zhuanye + '\'' +
                ", sosperson='" + sosperson + '\'' +
                ", biyedate=" + biyedate +
                ", zzmm='" + zzmm + '\'' +
                ", minzu='" + minzu + '\'' +
                ", xueli='" + xueli + '\'' +
                ", email='" + email + '\'' +
                ", empFk=" + empFk +
                ", remark='" + remark + '\'' +
                ", hirdate=" + hirdate +
                ", employee=" + employee +
                ", dept=" + dept +
                ", position=" + position +
                ", level=" + level +
                '}';
    }

    public String getDnum() {
        return dnum;
    }

    public void setDnum(String dnum) {
        this.dnum = dnum;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getZhuanye() {
        return zhuanye;
    }

    public void setZhuanye(String zhuanye) {
        this.zhuanye = zhuanye;
    }

    public String getSosperson() {
        return sosperson;
    }

    public void setSosperson(String sosperson) {
        this.sosperson = sosperson;
    }

    public Date getBiyedate() {
        return biyedate;
    }

    public void setBiyedate(Date biyedate) {
        this.biyedate = biyedate;
    }

    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm;
    }

    public String getMinzu() {
        return minzu;
    }

    public void setMinzu(String minzu) {
        this.minzu = minzu;
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getHirdate() {
        return hirdate;
    }

    public void setHirdate(Date hirdate) {
        this.hirdate = hirdate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Archives(String dnum, String landline, String school, String zhuanye, String sosperson, Date biyedate, String zzmm, String minzu, String xueli, String email, Integer empFk, String remark, Date hirdate, Employee employee, Dept dept, Position position, Level level) {
        this.dnum = dnum;
        this.landline = landline;
        this.school = school;
        this.zhuanye = zhuanye;
        this.sosperson = sosperson;
        this.biyedate = biyedate;
        this.zzmm = zzmm;
        this.minzu = minzu;
        this.xueli = xueli;
        this.email = email;
        this.empFk = empFk;
        this.remark = remark;
        this.hirdate = hirdate;
        this.employee = employee;
        this.dept = dept;
        this.position = position;
        this.level = level;
    }
}