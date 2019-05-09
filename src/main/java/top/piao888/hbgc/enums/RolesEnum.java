package top.piao888.hbgc.enums;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RolesEnmu.java
 * @Description TODO
 * @createTime 2019年03月10日 11:33:00
 */
public enum  RolesEnum {
    memu(0L,"母级菜单"),
    xmgl(95L,"项目管理"),
    jxgl(96L,"绩效管理"),
    zhgl(97L,"综合查询"),
    tjcx(98L,"统计查询"),
    xtgl(99L,"系统管理"),
    ;
    public  Long code;
    public  String massage;

    RolesEnum(Long i, String massage) {
        this.code=i;
        this.massage=massage;
    }
}
