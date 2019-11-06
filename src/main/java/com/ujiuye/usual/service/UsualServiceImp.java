package com.ujiuye.usual.service;

import com.ujiuye.pro.bean.Function;
import com.ujiuye.pro.bean.Model;
import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.Task;
import com.ujiuye.usual.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UsualServiceImp implements  UsualService {

    @Resource
    private TaskMapper taskMapper;

    @Override
    public List<Function> getFunction(Integer id) {
        return taskMapper.getFunction(id);
    }

    @Override
    public List<Employee> getPerson() {
        return taskMapper.getPerson();
    }

    @Override
    public boolean addTask(Task task) {
        task.setStatus(0);
        int row = taskMapper.addTask(task);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Task> getAllTask() {

        return taskMapper.getAllTask();
    }

    @Override
    public List<Task> getMySelf(Employee employee) {

        return taskMapper.getMySelf(employee);
    }

    @Override
    public boolean upateStatus(Integer id) {
        int row = taskMapper.upateStatus(id);
        if (row > 0){
            return true;
        }
        return false;
    }
}
