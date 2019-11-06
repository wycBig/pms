package com.ujiuye.pro.service;

import com.ujiuye.anal.bean.Analysis;
import com.ujiuye.pro.bean.Function;
import com.ujiuye.pro.mapper.FunctionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FunctionServiceImp implements  FunctionService {

    @Resource
    private FunctionMapper functionMapper;

    @Override
    public boolean addFunction(Function function) {
        int row = functionMapper.addFunction(function);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Function> getAllFunction() {

        return functionMapper.getAllFunction();
    }

    @Override
    public Function getAnalDel(Integer id) {

        return functionMapper.getAnalDel(id);
    }
}
