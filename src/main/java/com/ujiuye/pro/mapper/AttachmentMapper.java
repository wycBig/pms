package com.ujiuye.pro.mapper;


import com.ujiuye.cus.bean.Param;
import com.ujiuye.pro.bean.Attachment;

import java.util.List;

public interface AttachmentMapper {


    int insert(Attachment attachment);

    List<Attachment> getAttachAll();

    Attachment selectByPrimaryKey(Integer id);

    List<Attachment> getCondition(Param param);
}