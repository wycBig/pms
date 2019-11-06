package com.ujiuye.pro.controller;

import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.Param;
import com.ujiuye.pro.bean.Function;
import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pro")
public class ProjectController {

    //获取service实现类的对象
    @Autowired
    private ProjectService projectService;

    //获取到添加的项目
    @RequestMapping(value = "/addProject",method = RequestMethod.POST)
    public String addProject(Project project){
        boolean isSuccess = projectService.addProject(project);
        if (isSuccess){
            return "redirect:/pro/getProAll";
        }
        return "redirect:/pro/getProAll";
    }
    //获取所有的项目
    @RequestMapping(value = "/getAllPro",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getAllPro(){
        return projectService.getAllPro();
    }
    //获取所有的项目
    @RequestMapping(value = "/getProAll",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getProAll(){
        ModelAndView mv = new ModelAndView("project-base");
        List<Project> projects = projectService.getAllPro();
        mv.addObject("mv",projects);
        return mv;
    }
    //获取有需求的项目
    @RequestMapping(value = "/getNeedPro",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getNeedPro(){
        return projectService.getNeedPro();
    }
    //通过id查询某一条数据
    //查询某个客户信息
    @RequestMapping(value = "/get/{pid}",method = RequestMethod.GET)
    public String getProject(@PathVariable("pid") Integer pid, Map<String,Project> map){
        Project project = projectService.getProject(pid);
        map.put("pro",project);
        return "project-base-edit" ;
    }
    //通过id修改值
    @RequestMapping(value = "/edit/{pid}" ,method = RequestMethod.PUT)
    public String editPro(@PathVariable("pid") Integer pid,Project project){
        project.setPid(pid);
        boolean isSuccess = projectService.editPro(project);
        if (isSuccess){
            return "redirect:/pro/getProAll";
        }
        return "redirect:/pro/getProAll";
    }
    //通过id查询某一条数据
    //查询某个客户信息
    @RequestMapping(value = "/getDel/{pid}",method = RequestMethod.GET)
    public String getProjectDel(@PathVariable("pid") Integer pid, Map<String,Project> map){
        Project project = projectService.getProject(pid);
        map.put("pro",project);
        return "project-base-look" ;
    }
    //通过id删除
    @RequestMapping(value = "/deleteById/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteProjects(@PathVariable("id") String id,Map<String,Object> map){
        boolean isSuccess = projectService.deleteProjects(id);
        if (isSuccess){
            map.put("msg",200);
        }
        return "redirect:/pro/getAllPro";
    }
    //根据条件查询数据
    @RequestMapping(value = "/selectCondition",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getProCondition(Param param){
        ModelAndView mv = new ModelAndView("project-base");
        List<Project> projects = projectService.getProCondition(param);
        mv.addObject("mv",projects);
        return mv;
    }
}
