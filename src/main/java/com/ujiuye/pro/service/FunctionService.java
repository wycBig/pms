package com.ujiuye.pro.service;

import com.ujiuye.anal.bean.Analysis;
import com.ujiuye.pro.bean.Function;

import java.util.List;

public interface FunctionService {
    boolean addFunction(Function function);

    List<Function> getAllFunction();

    Function getAnalDel(Integer id);
}
