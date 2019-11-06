package com.ujiuye.pro.service;

import com.ujiuye.anal.bean.Analysis;
import com.ujiuye.pro.bean.Model;

import java.util.List;

public interface ModuleService {
    Analysis getTitle(Integer pid);

    boolean addProject(Model model);

    List<Model> getModel(Integer id);

    List<Model> getAllModel();
}
