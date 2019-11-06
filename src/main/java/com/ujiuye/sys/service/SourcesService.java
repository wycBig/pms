package com.ujiuye.sys.service;

import com.ujiuye.sys.bean.Sources;

import java.util.List;

public interface SourcesService {
    List<Sources> getSourcesList();

    void saveInfo(Sources sources);

    Sources selectSource(Integer id);

    void updateSource(Sources sources);

    void deleteSource(Integer id);

    List<Sources> getSourceById(Integer eid);
}
