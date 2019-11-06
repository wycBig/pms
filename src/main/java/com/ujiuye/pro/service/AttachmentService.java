package com.ujiuye.pro.service;

import com.ujiuye.cus.bean.Param;
import com.ujiuye.pro.bean.Attachment;

import java.util.List;

public interface AttachmentService {
    boolean addAttach(Attachment attachment);

    List<Attachment> getAttachAll();

    Attachment upLoadFile(Integer id);

    List<Attachment> getCondition(Param param);
}
