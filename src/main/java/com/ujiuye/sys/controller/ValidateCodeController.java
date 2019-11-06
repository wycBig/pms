package com.ujiuye.sys.controller;

import com.ujiuye.common.ValidateCode;
import com.ujiuye.sys.bean.Employee;
import com.ujiuye.sys.bean.Sources;
import com.ujiuye.sys.service.EmployeeService;
import com.ujiuye.sys.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/code")
public class ValidateCodeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SourcesService sourcesService;

    @RequestMapping(value="/getCode",method = RequestMethod.GET)
    public void getCode(@RequestParam(value = "time") String time, HttpServletRequest request, HttpServletResponse response) {
        ValidateCode code = new ValidateCode(100, 30, 4, 30, 25, "validateCode");
        code.getCode(request, response);

    }
    //用户验证登陆
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(String code, Employee employee, HttpSession session, RedirectAttributes redirectAttributes){
        String valiCode = (String)session.getAttribute("validateCode");
        Employee employee1 = null;
        if (code.equalsIgnoreCase(valiCode)){
            session.removeAttribute("validateCode");
            //携带数据到数据库查询用户信息
            employee1 = employeeService.login(employee);
            if (employee1 != null){
                Integer eid = employee1.getEid();
                List<Sources> list = sourcesService.getSourceById(eid);
                session.setAttribute("list",list);
                session.setAttribute("loginUser",employee1);
                return "redirect:/index.jsp";
            }else{
                redirectAttributes.addFlashAttribute("error","用户名或者密码错误");
                return "redirect:/login";
            }
        }else{
            redirectAttributes.addFlashAttribute("error","验证码错误");
            return "redirect:/login";
        }

    }
    //退出登录
    @RequestMapping(value = "/out",method = RequestMethod.GET)
    public String outlogin(HttpSession session){
            session.invalidate();
            return "redirect:/login";
    }
}
