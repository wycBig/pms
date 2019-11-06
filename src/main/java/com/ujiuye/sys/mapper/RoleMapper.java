package com.ujiuye.sys.mapper;


import com.ujiuye.sys.bean.Role;

import java.util.List;

public interface RoleMapper {
    void addRole(Role role);

    List<Role> getAllRole();
}