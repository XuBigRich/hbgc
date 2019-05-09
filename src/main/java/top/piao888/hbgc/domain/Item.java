package top.piao888.hbgc.domain;

import java.util.Date;

public class Item {
    private Long iid;

    private Long pid;

    private Long wid;

    private String tact;

    private String dist;

    private String dname;

    private Date tim;

    private String txt;

    public Long getIid() {
        return iid;
    }

    public void setIid(Long iid) {
        this.iid = iid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public String getTact() {
        return tact;
    }

    public void setTact(String tact) {
        this.tact = tact;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Date getTim() {
        return tim;
    }

    public void setTim(Date tim) {
        this.tim = tim;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}