package top.piao888.hbgc.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Report {
    private Long rid;

    private Long pid;

    private Long aid;

    private Long did;

    private Long wid;

    private Long tid;

    private Date retim;

    private String des;

    private String rea;

    private Long state;

    private BigDecimal num;

    private Date fintim;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Date getRetim() {
        return retim;
    }

    public void setRetim(Date retim) {
        this.retim = retim;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getRea() {
        return rea;
    }

    public void setRea(String rea) {
        this.rea = rea;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public Date getFintim() {
        return fintim;
    }

    public void setFintim(Date fintim) {
        this.fintim = fintim;
    }
}