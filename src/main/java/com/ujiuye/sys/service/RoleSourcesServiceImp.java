package com.ujiuye.sys.service;


import com.ujiuye.sys.mapper.RoleSourcesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleSourcesServiceImp implements RoleSourcesService {

    @Resource
    private RoleSourcesMapper roleSourcesMapper;


    @Override
    public void insertRoleSources(String ids, int roleid) {
        String[] split = ids.split(",");

        for (String i : split) {
            roleSourcesMapper.insertRoleSources(roleid,i);
        }
    }
}
