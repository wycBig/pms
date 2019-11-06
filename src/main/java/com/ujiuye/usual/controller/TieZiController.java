package com.ujiuye.usual.controller;

import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.ForumPost;
import com.ujiuye.usual.service.TieZiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/tz")
public class TieZiController {

    @Autowired
    private TieZiService tieZiService;

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(HttpSession session, ForumPost forumPost){
        Employee employee = (Employee) session.getAttribute("loginUser");
        forumPost.setEmpFk3(employee.getEid());
        forumPost.setCreatetime(new Date());
        boolean isSuccess = tieZiService.saveInfo(forumPost);
        if (isSuccess){
            return "redirect:/main.jsp";
        }
        return "redirect:/main.jsp";
    }

    //查询最新的四条帖子
    @RequestMapping(value = "/getFour",method = RequestMethod.GET)
    @ResponseBody
    public List<ForumPost> getFour(){
        List<ForumPost> forumPosts = tieZiService.getFour();
        return forumPosts;
    }
}
