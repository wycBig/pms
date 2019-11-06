package com.ujiuye.pro.mapper;

import com.ujiuye.anal.bean.Analysis;
import com.ujiuye.pro.bean.Function;

import java.util.List;

public interface FunctionMapper {

    int addFunction(Function function);

    List<Function> getAllFunction();

    Function getAnalDel(Integer id);
}