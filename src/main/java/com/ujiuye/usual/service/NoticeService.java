package com.ujiuye.usual.service;

import com.github.pagehelper.PageInfo;
import com.ujiuye.usual.bean.Notice;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    PageInfo<Notice> getAllNotice(Integer pageNum, Map<String, Object> params);

    List<Notice> getThree();

    Notice getOne(Integer nid);
}
