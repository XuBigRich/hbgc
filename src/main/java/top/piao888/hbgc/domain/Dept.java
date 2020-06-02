package top.piao888.hbgc.domain;

import java.io.Serializable;

public class Dept implements Serializable {
    private Long did;

    private Long pdid;

    private Long tid;

    private Long bid;

    private String name;

    private String ress;

    private String tel;

    private String tact;

    private String mob;

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public Long getPdid() {
        return pdid;
    }

    public void setPdid(Long pdid) {
        this.pdid = pdid;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRess() {
        return ress;
    }

    public void setRess(String ress) {
        this.ress = ress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTact() {
        return tact;
    }

    public void setTact(String tact) {
        this.tact = tact;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }
}