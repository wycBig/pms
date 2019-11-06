package com.ujiuye.sys.controller;


import com.ujiuye.common.MapEntity;
import com.ujiuye.sys.bean.Sources;
import com.ujiuye.sys.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/source")
public class SourcesController {

    @Autowired
    private SourcesService sourcesService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Sources> getSourcesList(){
        List<Sources> sources = sourcesService.getSourcesList();

        return sources;
    }
    //添加一个权限
    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(Sources sources){
        sourcesService.saveInfo(sources);
        return "redirect:/pm.jsp";
    }
    //通过id查询数据
    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ModelAndView selectSource(@PathVariable("id") Integer id){
        ModelAndView mv  = new ModelAndView("pm-edit");
        Sources sources = sourcesService.selectSource(id);
        System.out.println(sources);
        mv.addObject("source",sources);
        return mv;
    }
    //通过id修改数据
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public String updateSource(Sources sources){
        sourcesService.updateSource(sources);
        return "redirect:/pm.jsp";
    }
    //通过id删除数据
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public MapEntity deleteSource(@PathVariable("id") Integer id){
        sourcesService.deleteSource(id);
        return MapEntity.successMessage();
    }
}
