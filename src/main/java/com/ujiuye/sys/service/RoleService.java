package com.ujiuye.sys.service;

import com.ujiuye.sys.bean.Role;

import java.util.List;

public interface RoleService {
    int  addRole(Role role);

    List<Role> getAllRole();

}
