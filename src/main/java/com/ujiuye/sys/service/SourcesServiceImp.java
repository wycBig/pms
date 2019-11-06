package com.ujiuye.sys.service;

import com.alibaba.fastjson.JSON;
import com.ujiuye.sys.bean.Sources;
import com.ujiuye.sys.mapper.SourcesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SourcesServiceImp implements SourcesService {

    @Resource
    private SourcesMapper sourcesMapper;

    @Resource
    private JedisPool jedisPool;

    @Override
    public List<Sources> getSourcesList() {
        List<Sources> list = sourcesMapper.getSourcesList(0);
        queryChildren(list.get(0));
        return list;
    }

//添加数据
    @Override
    public void saveInfo(Sources sources) {
        sourcesMapper.saveInfo(sources);
    }

    //查询单挑数据
    @Override
    public Sources selectSource(Integer id) {
        return sourcesMapper.selectSource(id);
    }

    @Override
    public void updateSource(Sources sources) {
        sourcesMapper.updateSource(sources);
    }

    @Override
    public void deleteSource(Integer id) {
        sourcesMapper.deleteSource(id);
    }

    @Override
    public List<Sources> getSourceById(Integer eid) {
        Jedis jedis = jedisPool.getResource();

        String s1 = jedis.get(eid + "");
        List<Sources> sources1 = JSON.parseArray(s1, Sources.class);

        if (sources1 == null || sources1.size() == 0){
            sources1 = sourcesMapper.getSourceById(eid,1);
            for (Sources source : sources1) {
                Integer pid = source.getId();
                List<Sources> sourceById = sourcesMapper.getSourceById(eid, pid);
                source.setChildren(sourceById);
            }
            jedis.set(eid+"",JSON.toJSONString(sources1));
        }

        jedis.close();
        return sources1;
    }

    private void queryChildren(Sources sources) {
        Integer id = sources.getId();
        List<Sources> sources1 = sourcesMapper.getSourcesList(id);
        for(Sources ss :sources1 ){
            queryChildren(ss);
        }
        sources.setChildren(sources1);
    }
}
