package top.piao888.hbgc.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import top.piao888.hbgc.domain.Accs;
import top.piao888.hbgc.domain.Roles_Funs;
import top.piao888.hbgc.mapper.Roles_FunsMapper;

import java.util.List;
@Service
public class testService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private Roles_FunsMapper roles_funsMapper;
    public List getList(){
        String sql="select AID,DID,RID,USERNAME,PASSWORD,SEX,TEL,STAT,JOB,NAME,EM,DES from accs";
        return (List) jdbcTemplate.query(sql,((x,y) ->{
            Accs accs=new Accs();
            accs.setAid((long)x.getInt("AID"));
            accs.setDid((long)x.getInt("DID"));
            accs.setRid((long)x.getInt("RID"));
            accs.setUsername(x.getString("USERNAME"));
            accs.setPassword(x.getString("PASSWORD"));
            accs.setSex(x.getString("SEX"));
            accs.setTel(x.getString("TEL"));
            accs.setStat((short)x.getInt("STAT"));
            accs.setJob(x.getString("JOB"));
            return accs;
        }));
    }
    /*
     * 获取权限
     * */
    public List<Roles_Funs> qx(){
        Roles_Funs roles_funs=new Roles_Funs();
        roles_funs.setFid(100L);
        roles_funs.setRid(83L);
        List<Roles_Funs> p=roles_funsMapper.selectByRidOrFid(roles_funs);
        return p;
    }
}
