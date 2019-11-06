package com.ujiuye.usual.mapper;

import com.ujiuye.usual.bean.Notice;

import java.util.List;
import java.util.Map;

public interface NoticeMapper {

    List<Notice> getAllNotice(Map<String, String> map);

    List<Notice> getThree();

    Notice getOne(Integer nid);
}