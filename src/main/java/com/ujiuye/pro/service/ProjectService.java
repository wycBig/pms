package com.ujiuye.pro.service;

import com.ujiuye.cus.bean.Param;
import com.ujiuye.pro.bean.Project;

import java.util.List;

public interface ProjectService {
    boolean addProject(Project project);

    List<Project> getAllPro();

    List<Project> getNeedPro();

    Project getProject(Integer pid);

    boolean editPro(Project project);

    boolean deleteProjects(String id);

    List<Project> getProCondition(Param param);
}
