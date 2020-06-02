package top.piao888.hbgc.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Water {
    private Long wid;

    private Long pid;

    private BigDecimal cod;

    private BigDecimal am;

    private BigDecimal tp;

    private BigDecimal ph;

    private String des;

    private Date tim;

    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public BigDecimal getCod() {
        return cod;
    }

    public void setCod(BigDecimal cod) {
        this.cod = cod;
    }

    public BigDecimal getAm() {
        return am;
    }

    public void setAm(BigDecimal am) {
        this.am = am;
    }

    public BigDecimal getTp() {
        return tp;
    }

    public void setTp(BigDecimal tp) {
        this.tp = tp;
    }

    public BigDecimal getPh() {
        return ph;
    }

    public void setPh(BigDecimal ph) {
        this.ph = ph;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getTim() {
        return tim;
    }

    public void setTim(Date tim) {
        this.tim = tim;
    }
}