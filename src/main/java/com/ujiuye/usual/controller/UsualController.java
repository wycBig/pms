package com.ujiuye.usual.controller;

import com.ujiuye.pro.bean.Function;
import com.ujiuye.pro.bean.Model;
import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.Task;
import com.ujiuye.usual.service.UsualService;
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
@RequestMapping("/usual")
public class UsualController {

    @Autowired
    private UsualService usualService;

    //获取到任务信息
    @RequestMapping(value = "/getFunction/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Function> getFunction(@PathVariable("id") Integer id){
        return  usualService.getFunction(id);
    }
    //获取到所有的人员信息
    @RequestMapping(value = "/getPerson",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getPerson(){
        List<Employee> person = usualService.getPerson();
        return person;
    }
    //添加一条任务信息
    @RequestMapping(value = "/addTask",method = RequestMethod.POST)
    public String addTask(Task task){
        boolean isSuccess = usualService.addTask(task);
        if (isSuccess){
            return "redirect:/usual/getAllTask";
        }
        return "task";
    }
    //查询所有的任务
    @RequestMapping(value = "/getAllTask",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllTask(){
        ModelAndView mv = new ModelAndView("task");
        List<Task> tasks = usualService.getAllTask();
        mv.addObject("mv",tasks );
        return  mv;
    }
    //查询我的任务信息
    @RequestMapping(value = "/mytask",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getMySelf(HttpSession session){
        ModelAndView mv = new ModelAndView("task-my");
        //获取自己的任务
        Employee employee = (Employee)session.getAttribute("loginUser");
        List<Task> task = usualService.getMySelf(employee);
        mv.addObject("tasks",task);
        return mv;
    }
    //修改任务状态
    @RequestMapping(value = "/updateStatus/{id}",method =RequestMethod.PUT)
    public String upateStatus(@PathVariable("id") Integer id){
        boolean isSuccess = usualService.upateStatus(id);
        if (isSuccess){
            return "redirect:/usual/getAllTask";
        }else{
            return "redirect:/error.jsp";
        }
    }
}
