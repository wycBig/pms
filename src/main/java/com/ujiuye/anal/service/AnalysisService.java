package com.ujiuye.anal.service;

import com.ujiuye.anal.bean.Analysis;
import com.ujiuye.cus.bean.Param;

import java.util.List;

public interface AnalysisService {
    boolean insertAnal(Analysis analysis);

    List<Analysis> getAllAnal();

    boolean deleteAnal(String id);

    Analysis getAnalDel(Integer pid);

    boolean editAnal(Analysis analysis);

    List<Analysis> getProCondition(Param param);
}
