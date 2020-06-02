package top.piao888.hbgc.contruller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.piao888.hbgc.converter.ApplyForm2OSena;
import top.piao888.hbgc.domain.Accs;
import top.piao888.hbgc.domain.Sena;
import top.piao888.hbgc.enums.ResultEnum;
import top.piao888.hbgc.exception.HbgcException;
import top.piao888.hbgc.service.ZhanghaoService;
import top.piao888.hbgc.util.ResultVoUtil;
import top.piao888.hbgc.vo.request.ApplyAccountVo;
import top.piao888.hbgc.vo.ResponseVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LASContruller {
    @Autowired
    private ZhanghaoService zhanghaoService;

    @PostMapping("/login")
        public String login(HttpServletResponse response,HttpServletRequest request, @RequestParam String username, @RequestParam String password, Model model){
        Accs accs= zhanghaoService.login(response,username,password);  //响应式 设置cookie
//       Accs accs= zhanghaoService.login(request,username,password);  //请求式 设置cookie
        /*找出rid*/
        List menu=zhanghaoService.menu(accs.getRid());
        Map map=new HashMap();
        map.put("name",accs.getName());
        map.put("dname",accs.getDept().getName());
        map.put("rname",accs.getRoles().getName());
        map.put("menu",menu);
        model.addAttribute("map",map);
        return "main";
    }

    /*
    *跳转 apply页面  并发送区域信息
    */
    @ResponseBody
    @GetMapping("/beforesenaReg")
    public ResponseVo beforesenaReg(Model model){
        Map<String,Long> qy=zhanghaoService.qycx();
        return ResultVoUtil.success(qy);
    }
    /*
    *账号申报
    * */
    @PostMapping("/senaReg")
    @ResponseBody
    public void senaReg(@Valid ApplyAccountVo senaReg, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new HbgcException(ResultEnum.SENA_FAIL);
        }
        Sena sena=ApplyForm2OSena.convert(senaReg);
        zhanghaoService.sbzh(sena);
    }

}
