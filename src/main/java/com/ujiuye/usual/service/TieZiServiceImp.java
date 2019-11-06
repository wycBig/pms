package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.ForumPost;
import com.ujiuye.usual.mapper.ForumPostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TieZiServiceImp implements TieZiService {

    @Resource
    private ForumPostMapper forumPostMapper;
    @Override
    public boolean saveInfo(ForumPost forumPost) {
        int row = forumPostMapper.saveInfo(forumPost);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<ForumPost> getFour() {
        return forumPostMapper.getFour();

    }
}
