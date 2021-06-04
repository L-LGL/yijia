package com.zt.pojo;


public class comments {
    private  Integer id;
    private String cname;
    private String name;
    private String rid;
    private String com;
    private String admincom;
    private Integer nub;

    @Override
    public String toString() {
        return "comments{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", name='" + name + '\'' +
                ", rid='" + rid + '\'' +
                ", com='" + com + '\'' +
                ", admincom='" + admincom + '\'' +
                ", nub=" + nub +
                '}';
    }
    public comments(){}
    public comments(Integer id, String cname, String name, String rid, String com, String admincom, Integer nub) {
        this.id = id;
        this.cname = cname;
        this.name = name;
        this.rid = rid;
        this.com = com;
        this.admincom = admincom;
        this.nub = nub;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getAdmincom() {
        return admincom;
    }

    public void setAdmincom(String admincom) {
        this.admincom = admincom;
    }

    public Integer getNub() {
        return nub;
    }

    public void setNub(Integer nub) {
        this.nub = nub;
    }
}