package com.ujiuye.sys.service;


import com.ujiuye.sys.mapper.EmpRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmpRoleSserviceImp implements EmpRoleSservice {

    @Resource
    private EmpRoleMapper empRoleMapper;

    @Override
    public void insertERole(String[] roleid, int eid) {
        for (String s : roleid) {
            empRoleMapper.insertERole(s,eid);
        }

    }
}
