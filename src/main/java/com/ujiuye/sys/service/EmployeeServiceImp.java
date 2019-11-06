package com.ujiuye.sys.service;

import com.ujiuye.sys.bean.Employee;
import com.ujiuye.sys.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    //获取到容器中的Mapper接口
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getJiLi() {
        return employeeMapper.getJiLi();
    }

    @Override
    public Employee login(Employee employee) {

        return employeeMapper.login(employee);
    }

    @Override
    public int insertEmp(Employee employee) {
        employeeMapper.insertEmp(employee);
        int eid =  employee.getEid();
        return eid;
    }
}
