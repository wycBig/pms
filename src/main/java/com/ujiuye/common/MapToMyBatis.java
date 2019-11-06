package com.ujiuye.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapToMyBatis {
    //解析map
    public static Map<String, String> paramTOMyBatisMap(Map<String, Object> param) {
        Map<String,String>  map = new HashMap<String, String>();

        Set<Map.Entry<String, Object>> entries = param.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = (String)entry.getValue();
            //对键进行判断，若含like为模糊查询
            if (key.contains("like")){
                key = key.substring(key.lastIndexOf("_")+1);
                value="%"+value+"%";
            }
            map.put(key,value);
        }
        return  map;
    }
    public static String getParams(Map<String, Object> param) {
        //将参数拼接传到页面
        Set<Map.Entry<String, Object>> entries = param.entrySet();
        String gain = "";
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = (String) entry.getValue();
            gain = gain+"&"+"search_"+key+"="+value;
        }
        return gain;
    }

}
