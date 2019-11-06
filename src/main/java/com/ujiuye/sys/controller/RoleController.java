package com.ujiuye.sys.controller;

import com.ujiuye.common.MapEntity;
import com.ujiuye.sys.bean.Role;
import com.ujiuye.sys.service.RoleService;
import com.ujiuye.sys.service.RoleSourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleSourcesService roleSourcesService;

    @RequestMapping(value = "/add/{ids}",method = RequestMethod.POST)
    @ResponseBody
    public MapEntity addRole(Role role,@PathVariable("ids") String ids){
        int roleid = roleService.addRole(role);
        roleSourcesService.insertRoleSources(ids,roleid);
        return MapEntity.successMessage();
    }
    //获取所有的角色信息
    @RequestMapping(value = "/getRoles",method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getAllRole(){
        List<Role> roles = roleService.getAllRole();
        return  roles;
    }
}
