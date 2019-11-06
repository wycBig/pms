package com.ujiuye.usual.mapper;

import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.BaoXiao;

import java.util.List;
import java.util.Map;

public interface BaoXiaoMapper {


    int addMessage(BaoXiao baoXiao);

    List<BaoXiao> listAll();

    List<BaoXiao> getList(Map<String, String> map);
}