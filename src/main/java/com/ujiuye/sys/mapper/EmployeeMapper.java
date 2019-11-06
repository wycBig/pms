package com.ujiuye.sys.mapper;

import java.util.List;

import com.ujiuye.sys.bean.Employee;

public interface EmployeeMapper {

    List<Employee> getJiLi();

    Employee login(Employee employee);

    int insertEmp(Employee employee);
}