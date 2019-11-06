package com.ujiuye.sys.controller;


import com.ujiuye.sys.bean.Position;
import com.ujiuye.sys.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pos")
public class PositionController {

    @Autowired
    private PositionService positionService;

    //获取所有的职位
    @RequestMapping(value = "getPos",method = RequestMethod.GET)
    @ResponseBody
    public List<Position> getAll(){
        List<Position> positions =  positionService.getAll();
        return positions;
    }

}
