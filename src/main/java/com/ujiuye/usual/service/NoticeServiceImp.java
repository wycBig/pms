package com.ujiuye.usual.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.common.MapToMyBatis;
import com.ujiuye.usual.bean.Notice;
import com.ujiuye.usual.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImp implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public PageInfo<Notice> getAllNotice(Integer pageNum, Map<String, Object> params) {
        Map<String, String> map = MapToMyBatis.paramTOMyBatisMap(params);
        PageHelper.startPage(pageNum,4);
        List<Notice> notices = noticeMapper.getAllNotice(map);
        PageInfo<Notice> pageInfo = new PageInfo<Notice>(notices,3);
        return pageInfo;
    }

    @Override
    public List<Notice> getThree() {

        return noticeMapper.getThree();
    }

    @Override
    public Notice getOne(Integer nid) {

        return noticeMapper.getOne(nid);
    }
}
