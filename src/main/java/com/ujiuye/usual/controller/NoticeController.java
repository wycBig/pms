package com.ujiuye.usual.controller;


import com.github.pagehelper.PageInfo;
import com.ujiuye.common.MapEntity;
import com.ujiuye.common.MapToMyBatis;
import com.ujiuye.usual.bean.Notice;
import com.ujiuye.usual.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    //获取到所有的通知信息，异步
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public MapEntity getAllNotice(HttpServletRequest request, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum ){
        //获取表单的参数，条件查询的参数
        Map<String, Object> params = WebUtils.getParametersStartingWith(request, "search_");
        //按条件查询数据
        PageInfo<Notice> page = noticeService.getAllNotice(pageNum,params);
        //将集合中的值转化为字符串的参数，传到页面
        String paramVal = MapToMyBatis.getParams(params);
        //将有分页信息的page传入到页面
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        //MapEntity.map.put("page",page);
        return  MapEntity.successMessage().getKey("paramVal",paramVal).getKey("page",page).getKey("requestURI",requestURI);
    }
    //查看最新的三条通知
    @RequestMapping(value = "/getThree",method = RequestMethod.GET)
    @ResponseBody
    public MapEntity getThree(){
        List<Notice> notices = noticeService.getThree ();

        return MapEntity.successMessage().getKey("list",notices);
    }
    //根据id查询数据
    @RequestMapping(value = "/getOne/{nid}",method = RequestMethod.GET)
    @ResponseBody
    public Notice getOne(@PathVariable("nid") Integer nid ){
        Notice notices = noticeService.getOne(nid);

        return notices;
    }
}
