package com.ujiuye.pro.service;


import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.Param;
import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {

    //获取Mapper类的对象
    @Resource
    private ProjectMapper projectMapper;

    @Override
    public boolean addProject(Project project) {
        int row = projectMapper.addProject(project);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Project> getAllPro() {
        return projectMapper.getAllPro();
    }

    @Override
    public List<Project> getNeedPro() {

        return projectMapper.getNeedPro();
    }

    @Override
    public Project getProject(Integer pid) {
        return projectMapper.getProject(pid);
    }

    @Override
    public boolean editPro(Project project) {
        int row = projectMapper.editPro(project);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProjects(String id) {
        int row = projectMapper.deleteProjects(id);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Project> getProCondition(Param param) {
        List<Project> projects = null;
        if (param.getCid() == 0) {
            if (param.getOrderby() == 1 || param.getOrderby() == 0){
                //项目名、经理名、立定时间
                projects = projectMapper.getProCondition(param);

            }else {
                //项目名、经理名、完成时间
                projects = projectMapper.getProConditionDESC(param);
            }
        }else if (param.getCid() == 1){
            if (param.getOrderby() == 1 || param.getOrderby() == 0){
                //项目名、立定时间
                projects =projectMapper.getByProPanyAsc(param);
            }else {
                //项目名、完成时间
                projects =projectMapper.getByProPanyDesc(param);
            }
        }else {
            if (param.getOrderby() == 1 || param.getOrderby() == 0){
                //经理名、立定时间
                projects =projectMapper.getByPersonAsc(param);
            }else {
                //经理名、完成时间
                projects =projectMapper.getByPersonDesc(param);
            }
        }
        return projects;
    }
}
