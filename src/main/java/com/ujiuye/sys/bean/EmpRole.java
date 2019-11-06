package com.ujiuye.sys.bean;

public class EmpRole {
    private Integer eid;
    private Integer rid;

    public EmpRole(){
        super();
    }
    public EmpRole(Integer eid, Integer rid) {
        this.eid = eid;
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "EmpRole{" +
                "eid=" + eid +
                ", rid=" + rid +
                '}';
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
