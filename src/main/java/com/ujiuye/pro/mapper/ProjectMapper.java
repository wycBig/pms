package com.ujiuye.pro.mapper;

import com.ujiuye.cus.bean.Param;
import com.ujiuye.pro.bean.Project;

import java.util.List;

public interface ProjectMapper {

    int addProject(Project project);

    List<Project> getAllPro();

    List<Project> getNeedPro();

    Project getProject(Integer pid);

    int editPro(Project project);

    int deleteProjects(String id);

    List<Project> getProCondition(Param param);

    List<Project> getProConditionDESC(Param param);

    List<Project> getByProPanyAsc(Param param);

    List<Project> getByProPanyDesc(Param param);

    List<Project> getByPersonAsc(Param param);

    List<Project> getByPersonDesc(Param param);
}