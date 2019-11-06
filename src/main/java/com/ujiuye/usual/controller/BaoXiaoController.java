package com.ujiuye.usual.controller;

import com.github.pagehelper.PageInfo;
import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.BaoXiao;
import com.ujiuye.usual.service.BaoXiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/bx")
public class BaoXiaoController {

    @Autowired
    private BaoXiaoService baoXiaoService;

    //查询所有数据信息
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView listAll(){
        //获取当前用户的信息
        List<BaoXiao> bxList = baoXiaoService.listAll();
        ModelAndView mv = new ModelAndView("baoxiao-task");
        mv.addObject("mv",bxList);
        return mv;
    }
    //分页获取数据
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getList(HttpServletRequest request, HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        //获取参数利用web框架提供的方法
        Map<String, Object> param = WebUtils.getParametersStartingWith(request, "search_");
        //创建一个modelandview对象
        ModelAndView mv = null;
        //定一个变量用来接收参数信息。
        String params = getParams(param);
        String requestURI = request.getRequestURI();
        //System.out.println(requestURI);
        //获取当前用户的信息,对是否登陆进行判断
        if (session.getAttribute("loginUser")!= null){
            Employee employee = (Employee)session.getAttribute("loginUser");
            PageInfo<BaoXiao> page = baoXiaoService.getList(employee,pageNum,param);
            mv = new ModelAndView("mybaoxiao-base");
            mv.addObject("mv",page);
            mv.addObject("paramterMap",params);
            mv.addObject("path",requestURI);
            return mv;
        }else {
            mv = new ModelAndView("login");
            return mv;
        }

    }

    private String getParams(Map<String, Object> param) {
        //将参数拼接传到页面
        Set<Map.Entry<String, Object>> entries = param.entrySet();
        String gain = "";
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = (String) entry.getValue();
            gain = gain+"&"+"search_"+key+"="+value;
        }
        return gain;
    }

    //添加数据
    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String addMessage(BaoXiao baoXiao,HttpSession session){
        //获取当前用户的信息
        Employee employee = (Employee)session.getAttribute("loginUser");
        //将申请报销的用户的id存入到表中
        baoXiao.setEmpFk(employee.getEid());
        //调用方法将数据插入到数据库中
        boolean isSuccess = baoXiaoService.addMessage(baoXiao);
        if (isSuccess){
            return "redirect:/bx/list";
        }
        return "redirect/project-base-add";
    }

}
