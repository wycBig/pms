package com.ujiuye.pro.controller;

import com.ujiuye.anal.bean.Analysis;
import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.Param;
import com.ujiuye.pro.bean.Function;
import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.service.FunctionService;
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
@RequestMapping("/func")
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    //添加数据
    @RequestMapping(value = "/addFunction",method = RequestMethod.POST)
    public String addFunction(Function function){
        boolean isSuccess = functionService.addFunction(function);
        if (isSuccess){
            return "redirect:/func/list";
        }
        return "redirect:/func/list";
    }
    //查询所有的数据
    //查询所有的客户信息
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllFunction(){
        ModelAndView mv = new ModelAndView("project-function");
        List<Function> functions = functionService.getAllFunction();
        mv.addObject("mv",functions);
        return mv;
    }
    //通过id查询某一条数据
    //查询某个客户信息
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public String getFunc(@PathVariable("id") Integer id, Map<String,Function> map){
        Function function = functionService.getAnalDel(id);
        map.put("func",function);
        return "project-function-edit" ;
    }
    /*//通过id修改值
    @RequestMapping(value = "/edit/{pid}" ,method = RequestMethod.PUT)
    public String editPro(@PathVariable("pid") Integer pid,Project project){
        project.setPid(pid);
        boolean isSuccess = projectService.editPro(project);
        if (isSuccess){
            return "redirect:/pro/getProAll";
        }
        return "redirect:/pro/getProAll";
    }
    */
   /* //通过id删除
    @RequestMapping(value = "/deleteById/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteProjects(@PathVariable("id") String id,Map<String,Object> map){
        boolean isSuccess = projectService.deleteProjects(id);
        if (isSuccess){
            map.put("msg",200);
        }
        return "redirect:/pro/getAllPro";
    }*/
    //通过id查询某一条数据
    //查询某个客户信息
    @RequestMapping(value = "/getDel/{id}",method = RequestMethod.GET)
    public String getFuncDel(@PathVariable("id") Integer id, Map<String, Function> map){
        Function function = functionService.getAnalDel(id);
        map.put("func",function);
        return "project-function-look" ;
    }
    //根据条件查询数据
    /*@RequestMapping(value = "/selectCondition",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getProCondition(Param param){
        ModelAndView mv = new ModelAndView("project-base");
        List<Project> projects = projectService.getProCondition(param);
        mv.addObject("mv",projects);
        return mv;
    }*/
}
