package com.ujiuye.pro.service;

import com.ujiuye.cus.bean.Param;
import com.ujiuye.pro.bean.Attachment;
import com.ujiuye.pro.mapper.AttachmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AttachmentServiceImp implements AttachmentService {

    @Resource
    private AttachmentMapper mapper;

    @Override
    public boolean addAttach(Attachment attachment) {
        int row = mapper.insert(attachment);
        if (row > 0){
            return true;
        }
        return false;
    }

       @Override
    public List<Attachment> getAttachAll() {
        return mapper.getAttachAll();
    }

    @Override
    public Attachment upLoadFile(Integer id) {

       return  mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Attachment> getCondition(Param param) {

        return mapper.getCondition(param);
    }
}
