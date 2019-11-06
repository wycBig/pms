package com.ujiuye.usual.mapper;

import com.ujiuye.pro.bean.Function;
import com.ujiuye.pro.bean.Model;
import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {

    List<Function> getFunction(Integer id);

    List<Employee> getPerson();

    int addTask(Task task);

    List<Task> getAllTask();

    List<Task> getMySelf(Employee employee);

    int upateStatus(@Param("id") Integer id);
}