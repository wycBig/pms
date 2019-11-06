package com.ujiuye.sys.service;


import com.ujiuye.sys.bean.Role;
import com.ujiuye.sys.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int  addRole(Role role) {
        roleMapper.addRole(role);
        return role.getRoleid();
    }

    @Override
    public List<Role> getAllRole() {

        return roleMapper.getAllRole();
    }
}
