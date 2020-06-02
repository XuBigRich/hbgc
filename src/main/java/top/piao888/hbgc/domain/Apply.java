package top.piao888.hbgc.domain;

import java.util.Date;

public class Apply {
    private Long pid;

    private Long aaid;

    private Long did;

    private Long lastid;

    private Long curdid;

    private Long wid;

    private Date tim;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getAaid() {
        return aaid;
    }

    public void setAaid(Long aaid) {
        this.aaid = aaid;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public Long getLastid() {
        return lastid;
    }

    public void setLastid(Long lastid) {
        this.lastid = lastid;
    }

    public Long getCurdid() {
        return curdid;
    }

    public void setCurdid(Long curdid) {
        this.curdid = curdid;
    }

    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public Date getTim() {
        return tim;
    }

    public void setTim(Date tim) {
        this.tim = tim;
    }
}