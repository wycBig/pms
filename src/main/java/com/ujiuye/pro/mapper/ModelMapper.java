package com.ujiuye.pro.mapper;

import com.ujiuye.anal.bean.Analysis;
import com.ujiuye.pro.bean.Model;

import java.util.List;

public interface ModelMapper {

    Analysis getTitle(Integer pid);

    int addProject(Model model);

    List<Model> getModel(Integer id);

    List<Model> getAllModel();
}