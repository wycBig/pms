package com.ujiuye.usual.service;

import com.github.pagehelper.PageInfo;
import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.BaoXiao;

import java.util.List;
import java.util.Map;

public interface BaoXiaoService {
    PageInfo<BaoXiao> getList(Employee employee, Integer pageNum, Map<String, Object> param);

    boolean addMessage(BaoXiao baoXiao);

    List<BaoXiao> listAll();
}
