package com.ujiuye.sys.mapper;

import org.apache.ibatis.annotations.Param;

public interface EmpRoleMapper {
    void insertERole(@Param("s") String s,@Param("eid") int eid);
}
