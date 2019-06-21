package top.piao888.hbgc.domain;


import lombok.Data;

import java.io.Serializable;

@Data
public class Accs implements Serializable {
    private Long aid;
    private Long did;
    private Long rid;
    private String username;
    private String password;
    private String sex;
    private String tel;
    private Short stat;
    private String job;
    private String name;
    private String em;
    private String des;
    private Dept dept;
    private Roles roles;

}