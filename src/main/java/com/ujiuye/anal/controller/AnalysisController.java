package com.ujiuye.anal.controller;

import com.ujiuye.anal.bean.Analysis;
import com.ujiuye.anal.service.AnalysisService;
import com.ujiuye.cus.bean.Param;
import com.ujiuye.pro.bean.Project;
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
@RequestMapping("/anal")
public class AnalysisController {

    //获取容器中AnalysisService对象
    @Autowired
    private AnalysisService analysisService;

    @RequestMapping(value = "/insertAnal",method = RequestMethod.POST)
    public String insertAnal(Analysis analysis){
        boolean isSuccess = analysisService.insertAnal(analysis);
        if (isSuccess){
            return "redirect:/anal/getAllAnal";
        }
        return "redirect:/anal/getAllAnal";
    }
    //获取所有的项目
    @RequestMapping(value = "/getAllAnal",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllAnal(){
        ModelAndView mv = new ModelAndView("project-need");
        List<Analysis> analyses = analysisService.getAllAnal();
        mv.addObject("mv",analyses);
        return mv;
    }
    //通过id删除
    @RequestMapping(value = "/deleteById/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAnal(@PathVariable("id") String id, Map<String,Object> map){
        boolean isSuccess = analysisService.deleteAnal(id);
        if (isSuccess){
            map.put("msg",200);
        }
        return "redirect:/anal/getAllAnal";
    }
    //通过id修改值
    @RequestMapping(value = "/update/{pid}" ,method = RequestMethod.PUT)
    public String editAnal(@PathVariable("pid") Integer pid,Analysis analysis){
        analysis.setId(pid);
        boolean isSuccess = analysisService.editAnal(analysis);
        if (isSuccess){
            return "redirect:/anal/getAllAnal";
        }
        return "redirect:/anal/getAllAnal";
    }
    //通过id查询某一条数据
    //查询某个客户信息
    @RequestMapping(value = "/getDel/{pid}",method = RequestMethod.GET)
    public String getAnalDel(@PathVariable("pid") Integer pid, Map<String,Analysis> map){
        Analysis analysis = analysisService.getAnalDel(pid);
        map.put("anal",analysis);
        return "project-need-look" ;
    }
    //通过id查询某一条数据
    //查询某个客户信息
    @RequestMapping(value = "/get/{pid}",method = RequestMethod.GET)
    public String getAnal(@PathVariable("pid") Integer pid, Map<String,Analysis> map){
        Analysis analysis = analysisService.getAnalDel(pid);
        map.put("anal",analysis);
        return "project-need-edit" ;
    }
    //根据条件查询数据
    @RequestMapping(value = "/selectCondition",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getProCondition(Param param){
        ModelAndView mv = new ModelAndView("project-need");
        List<Analysis> analyses = analysisService.getProCondition(param);
        mv.addObject("mv",analyses);
        return mv;
    }
}
