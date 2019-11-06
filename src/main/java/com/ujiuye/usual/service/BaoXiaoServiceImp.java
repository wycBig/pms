package com.ujiuye.usual.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.BaoXiao;
import com.ujiuye.usual.mapper.BaoXiaoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class BaoXiaoServiceImp implements BaoXiaoService {

    @Resource
    private BaoXiaoMapper baoXiaoMapper;

    @Override
    public PageInfo<BaoXiao> getList(Employee employee, Integer pageNum, Map<String, Object> param) {
        //创建一个方法用来解析param
        Map<String,String> map =paramTOMyBatisMap(param);
        map.put("eid",employee.getEid().toString());
        PageHelper.startPage(pageNum,3);
        List<BaoXiao> list = baoXiaoMapper.getList(map);
        PageInfo<BaoXiao> pageInfo = new PageInfo<BaoXiao>(list,4);
        return pageInfo;
    }
    //解析map
    private Map<String, String> paramTOMyBatisMap(Map<String, Object> param) {
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

    @Override
    public boolean addMessage(BaoXiao baoXiao) {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        baoXiao.setBxid(s);
        baoXiao.setBxstatus(0);
        int row = baoXiaoMapper.addMessage(baoXiao);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<BaoXiao> listAll() {

        return baoXiaoMapper.listAll();
    }
}
