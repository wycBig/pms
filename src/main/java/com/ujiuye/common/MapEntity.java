package com.ujiuye.common;

import java.util.HashMap;
import java.util.Map;

public class MapEntity {
    public Map<String,Object> map = new HashMap<String, Object>();

    //成功回调方法
    public static MapEntity successMessage(){
        MapEntity entity = new MapEntity();
        entity.map.put("statusCode",200);
        entity.map.put("message","获取成功");
        return  entity;
    }
    //成功回调方法
    public static MapEntity faultMessage(){
        MapEntity entity = new MapEntity();
        entity.map.put("statusCode",500);
        entity.map.put("message","获取失败");
        return  entity;
    }
    //将搜索关键字传入
    public  MapEntity getKey(String key,Object object){
        this.map.put(key,object);
        return this;
    }
}
