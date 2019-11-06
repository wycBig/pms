package com.ujiuye.usual.mapper;


import com.ujiuye.usual.bean.ForumPost;

import java.util.List;

public interface ForumPostMapper {

    int saveInfo(ForumPost forumPost);

    List<ForumPost> getFour();

}