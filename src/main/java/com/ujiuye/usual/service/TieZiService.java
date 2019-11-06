package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.ForumPost;

import java.util.List;

public interface TieZiService {
    boolean saveInfo(ForumPost forumPost);

    List<ForumPost> getFour();
}
