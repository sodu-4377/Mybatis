package com.example.mybatisdemo2.vo;

public class StudenAndClassroom {
    private String sid;
    private String sname;
    private int sage;
    private String sroom;

    @Override
    public String toString() {
        return "StudenAndClassroom{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", sroom='" + sroom + '\'' +
                ", cid='" + cid + '\'' +
                ", croomid='" + croomid + '\'' +
                '}';
    }

    private String cid;
    private String croomid;

    public StudenAndClassroom() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSaddr() {
        return sroom;
    }

    public void setSaddr(String sroom) {
        this.sroom = sroom;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCroomid() {
        return croomid;
    }

    public void setCroomid(String croomid) {
        this.croomid = croomid;
    }
}
