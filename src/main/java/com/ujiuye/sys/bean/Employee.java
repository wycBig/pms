package com.ujiuye.sys.bean;

import com.ujiuye.usual.bean.Archives;

import java.util.Date;

public class Employee {
    private Integer eid;

    private String ename;

    private String esex;

    private Integer eage;

    private String telephone;

    private Date hiredate;

    private String pnum;

    private String username;

    private String password;

    private String remark;

    private Integer pFk;

    private Integer dFk;

    private Integer lFk;

    private Archives archives;

    public Employee() {
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esex='" + esex + '\'' +
                ", eage=" + eage +
                ", telephone='" + telephone + '\'' +
                ", hiredate=" + hiredate +
                ", pnum='" + pnum + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", remark='" + remark + '\'' +
                ", pFk=" + pFk +
                ", dFk=" + dFk +
                ", lFk=" + lFk +
                ", archives=" + archives +
                '}';
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public Integer getEage() {
        return eage;
    }

    public void setEage(Integer eage) {
        this.eage = eage;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getpFk() {
        return pFk;
    }

    public void setpFk(Integer pFk) {
        this.pFk = pFk;
    }

    public Integer getdFk() {
        return dFk;
    }

    public void setdFk(Integer dFk) {
        this.dFk = dFk;
    }

    public Integer getlFk() {
        return lFk;
    }

    public void setlFk(Integer lFk) {
        this.lFk = lFk;
    }

    public Archives getArchives() {
        return archives;
    }

    public void setArchives(Archives archives) {
        this.archives = archives;
    }

    public Employee(Integer eid, String ename, String esex, Integer eage, String telephone, Date hiredate, String pnum, String username, String password, String remark, Integer pFk, Integer dFk, Integer lFk, Archives archives) {
        this.eid = eid;
        this.ename = ename;
        this.esex = esex;
        this.eage = eage;
        this.telephone = telephone;
        this.hiredate = hiredate;
        this.pnum = pnum;
        this.username = username;
        this.password = password;
        this.remark = remark;
        this.pFk = pFk;
        this.dFk = dFk;
        this.lFk = lFk;
        this.archives = archives;
    }
}