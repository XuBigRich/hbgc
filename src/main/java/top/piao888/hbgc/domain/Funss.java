package top.piao888.hbgc.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Funss {
    private Long fid;
    private Long pfid;
    private String uri;
    private String des;
    //查询父权限的 子权限  //内部关联
    private List<Funss> childFuns =new ArrayList<>();

}