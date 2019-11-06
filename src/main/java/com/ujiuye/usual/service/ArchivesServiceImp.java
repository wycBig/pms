package com.ujiuye.usual.service;

import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.Archives;
import com.ujiuye.usual.mapper.ArchivesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArchivesServiceImp implements ArchivesService {

    @Resource
    private ArchivesMapper archivesMappera;
    @Override
    public List<Archives> getAllArch() {

        return  archivesMappera.getAllArch();
    }

    @Override
    public Archives getArch(String dnum) {

        return archivesMappera.getArch(dnum);
    }

    @Override
    public List<Employee> getEmail(Integer eid) {

        return archivesMappera.getEmail(eid);
    }
}
