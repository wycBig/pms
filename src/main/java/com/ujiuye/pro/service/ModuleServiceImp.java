package com.ujiuye.pro.service;

import com.ujiuye.anal.bean.Analysis;
import com.ujiuye.pro.bean.Model;
import com.ujiuye.pro.mapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModuleServiceImp implements ModuleService {

    @Resource
    private ModelMapper modelMapper;
    @Override
    public Analysis getTitle(Integer pid) {

        return modelMapper.getTitle(pid);
    }

    @Override
    public boolean addProject(Model model) {
        int row = modelMapper.addProject(model);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Model> getModel(Integer id) {
        return modelMapper.getModel(id);
    }

    @Override
    public List<Model> getAllModel() {

        return modelMapper.getAllModel();
    }
}
