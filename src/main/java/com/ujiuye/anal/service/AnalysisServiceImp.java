package com.ujiuye.anal.service;

import com.ujiuye.anal.bean.Analysis;
import com.ujiuye.anal.mapper.AnalysisMapper;
import com.ujiuye.cus.bean.Param;
import com.ujiuye.pro.bean.Project;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AnalysisServiceImp implements AnalysisService {

    @Resource
    private AnalysisMapper analysisMapper;
    @Override
    public boolean insertAnal(Analysis analysis) {
        analysis.setAddtime(new Date());
        analysis.setUpdatetime(new Date());
        int row = analysisMapper.insertAnal(analysis);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Analysis> getAllAnal() {

        return analysisMapper.getAllAnal();
    }

    @Override
    public boolean deleteAnal(String id) {

        int row = analysisMapper.deleteAnal(id);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public Analysis getAnalDel(Integer pid) {
        return analysisMapper.getAnalDel(pid);
    }

    @Override
    public boolean editAnal(Analysis analysis) {
        int row = analysisMapper.editAnal(analysis);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Analysis> getProCondition(Param param) {
        List<Analysis> analyses = null;
        if (param.getCid() == 0) {
            if (param.getOrderby() == 1 || param.getOrderby() == 0){
                //项目名、标题、添加时间
                analyses = analysisMapper.getProCondition(param);

            }else {
                //项目名、标题、修改时间
                analyses = analysisMapper.getProConditionDESC(param);
            }
        }else if (param.getCid() == 1){
            if (param.getOrderby() == 1 || param.getOrderby() == 0){
                //项目名、添加时间
                analyses =analysisMapper.getByProPanyAsc(param);
            }else {
                //项目名、修改时间
                analyses =analysisMapper.getByProPanyDesc(param);
            }
        }else {
            if (param.getOrderby() == 1 || param.getOrderby() == 0){
                //标题、添加时间
                analyses =analysisMapper.getByPersonAsc(param);
            }else {
                //标题、修改时间
                analyses =analysisMapper.getByPersonDesc(param);
            }
        }
        return analyses;
    }

}
