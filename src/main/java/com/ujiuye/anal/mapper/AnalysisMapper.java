package com.ujiuye.anal.mapper;

import com.ujiuye.anal.bean.Analysis;
import com.ujiuye.cus.bean.Param;

import java.util.List;

public interface AnalysisMapper {

    int insertAnal(Analysis analysis);

    List<Analysis> getAllAnal();

    int deleteAnal(String id);

    Analysis getAnalDel(Integer pid);

    int editAnal(Analysis analysis);

    List<Analysis> getProCondition(Param param);

    List<Analysis> getProConditionDESC(Param param);

    List<Analysis> getByProPanyAsc(Param param);

    List<Analysis> getByProPanyDesc(Param param);

    List<Analysis> getByPersonAsc(Param param);

    List<Analysis> getByPersonDesc(Param param);
}