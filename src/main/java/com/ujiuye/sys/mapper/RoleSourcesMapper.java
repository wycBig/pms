package com.ujiuye.sys.mapper;

import org.apache.ibatis.annotations.Param;

public interface RoleSourcesMapper {
    void insertRoleSources(@Param("roleid") int roleid, @Param("i") String i);
}
