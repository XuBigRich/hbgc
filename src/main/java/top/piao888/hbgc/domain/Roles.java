package top.piao888.hbgc.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Roles  implements Serializable {
    private Long rid;
    private String name;
    private String des;
    private List<Funs> funs;
}