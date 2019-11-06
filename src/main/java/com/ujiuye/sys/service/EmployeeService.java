package com.ujiuye.sys.service;

import com.ujiuye.sys.bean.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getJiLi();

    Employee login(Employee employee);

    int insertEmp(Employee employee);
}
