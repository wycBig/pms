package com.ujiuye.sys.controller;

import com.ujiuye.sys.bean.Employee;
import com.ujiuye.sys.service.EmpRoleSservice;
import com.ujiuye.sys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    //获取到容器中的service对象
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmpRoleSservice empRoleSservice;

    //获取到经理
    @RequestMapping(value = "/getJiLi",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getJiLi(){
        return employeeService.getJiLi();
    }
    //插入数据
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insertEmp(String[] roleid,Employee employee){
        int eid =  employeeService.insertEmp(employee);
        empRoleSservice.insertERole(roleid,eid);
        return "redirect:/user.jsp";
    }
}
