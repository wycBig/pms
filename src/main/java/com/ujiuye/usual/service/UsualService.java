package com.ujiuye.usual.service;

import com.ujiuye.pro.bean.Function;
import com.ujiuye.pro.bean.Model;
import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.Task;

import java.util.List;

public interface UsualService {
    List<Function> getFunction(Integer id);

    List<Employee> getPerson();

    boolean addTask(Task task);

    List<Task> getAllTask();

    List<Task> getMySelf(Employee employee);

    boolean upateStatus(Integer id);
}
