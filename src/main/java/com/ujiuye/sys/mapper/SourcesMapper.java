package com.ujiuye.sys.mapper;


import com.ujiuye.sys.bean.Sources;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SourcesMapper {

    List<Sources> getSourcesList(int i);

    void saveInfo(Sources sources);


    Sources selectSource(Integer id);

    void updateSource(Sources sources);

    void deleteSource(Integer id);

    List<Sources> getSourceById(@Param("eid") Integer eid, @Param("pid") Integer pid);
}