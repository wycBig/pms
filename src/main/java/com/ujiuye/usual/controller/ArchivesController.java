package com.ujiuye.usual.controller;


import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.Archives;
import com.ujiuye.usual.service.ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/arch")
public class ArchivesController {

    @Autowired
    private ArchivesService archivesService;

    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllArch(){
        List<Archives> archives = archivesService.getAllArch();
        ModelAndView mv  = new ModelAndView("archives");
        mv.addObject("list",archives);
        return  mv;
    }
    //查询指定的信息
    @RequestMapping(value = "/getArch/{dnum}",method = RequestMethod.GET)
    public String getArch(@PathVariable("dnum") String dnum,Map<String,Archives> map ){
        Archives arch = archivesService.getArch(dnum);
        map.put("arch",arch);
        return "myarchives";
    }
    //查询人对应的邮箱地址
    @RequestMapping(value = "/getEmail",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmail(HttpSession session){
        //获取当前用户的id
        Employee employee = (Employee)session.getAttribute("loginUser");
        Integer eid = employee.getEid();
        List<Employee> employees = archivesService.getEmail(eid);
        return  employees;
    }
}
