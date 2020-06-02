package top.piao888.hbgc.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Acceptfile {
    private Long afid;

    private Long pid;

    private String fn;

    private String tp;

    private BigDecimal siz;

    private Date tim;

    private byte[] txt;

    public Long getAfid() {
        return afid;
    }

    public void setAfid(Long afid) {
        this.afid = afid;
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