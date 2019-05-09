package top.piao888.hbgc.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Stepfile {
    private Long sfid;

    private Long sid;

    private Long pid;

    private String fn;

    private String tp;

    private BigDecimal siz;

    private Date tim;

    private byte[] txt;

    public Long getSfid() {
        return sfid;
    }

    public void setSfid(Long sfid) {
        this.sfid = sfid;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public BigDecimal getSiz() {
        return siz;
    }

    public void setSiz(BigDecimal siz) {
        this.siz = siz;
    }

    public Date getTim() {
        return tim;
    }

    public void setTim(Date tim) {
        this.tim = tim;
    }

    public byte[] getTxt() {
        return txt;
    }

    public void setTxt(byte[] txt) {
        this.txt = txt;
    }
}