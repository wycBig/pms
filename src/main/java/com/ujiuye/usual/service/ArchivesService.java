package com.ujiuye.usual.service;

import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.Archives;

import java.util.List;

public interface ArchivesService {
    List<Archives> getAllArch();

    Archives getArch(String dnum);

    List<Employee> getEmail(Integer eid);
}
