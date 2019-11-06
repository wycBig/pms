package com.ujiuye.common;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = {SQLException.class})
    @ResponseBody
    public MapEntity handleSqlException(){
        return MapEntity.faultMessage();
    }
    @ExceptionHandler(value = {handlePayException.class})
    @ResponseBody
    public MapEntity handlePayException(){

        return MapEntity.faultMessage();
    }
}
