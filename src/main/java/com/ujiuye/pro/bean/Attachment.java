package com.ujiuye.pro.bean;

public class Attachment {
    private Integer id;

    private Integer proFk;

    private String attname;

    private String attdis;

    private String remark;

    private String path;
    private Project project;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProFk() {
        return proFk;
    }

    public void setProFk(Integer proFk) {
        this.proFk = proFk;
    }

    public String getAttname() {
        return attname;
    }

    public void setAttname(String attname) {
        this.attname = attname;
    }

    public String getAttdis() {
        return attdis;
    }

    public void setAttdis(String attdis) {
        this.attdis = attdis;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Attachment(Integer id, Integer proFk, String attname, String attdis, String remark, String path, Project project) {
        this.id = id;
        this.proFk = proFk;
        this.attname = attname;
        this.attdis = attdis;
        this.remark = remark;
        this.path = path;
        this.project = project;
    }
    public Attachment(){

    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", proFk=" + proFk +
                ", attname='" + attname + '\'' +
                ", attdis='" + attdis + '\'' +
                ", remark='" + remark + '\'' +
                ", path='" + path + '\'' +
                ", project=" + project +
                '}';
    }
}