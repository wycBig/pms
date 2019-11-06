package com.ujiuye.pro.controller;

import com.ujiuye.anal.bean.Analysis;
import com.ujiuye.pro.bean.Model;
import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mod")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    //获取到需求
    @RequestMapping(value = "/gettitle/{pname}",method = RequestMethod.GET)
    @ResponseBody
    public Analysis gettitle(@PathVariable("pname") Integer pid){
       return  moduleService.getTitle(pid);
    }
    //获取到添加的项目
    @RequestMapping(value = "/addModel",method = RequestMethod.POST)
    public String addModel(Model model){
        boolean isSuccess = moduleService.addProject(model);
        if (isSuccess){
            return "redirect:/mod/getAllModel";
        }
        return "redirect:/mod/getAllModel";
    }
    //获取到模块信息
    @RequestMapping(value = "/getModel/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Model> getModel(@PathVariable("id") Integer id){
        return  moduleService.getModel(id);
    }
    //获取所有的项目
    @RequestMapping(value = "/getAllModel",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllModel(){
        ModelAndView mv = new ModelAndView("project-model");
        List<Model> models = moduleService.getAllModel();
        mv.addObject("mv",models);
        return mv;
    }
}
