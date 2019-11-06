package com.ujiuye.cus.service;

import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.Param;
import com.ujiuye.cus.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public boolean insertCustomer(Customer customer) {
        customer.setAddtime(new Date());
        int row = customerMapper.insertCustomer(customer);

        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerMapper.getAllCustomer();
    }

    @Override
    public Customer getCustomer(Integer id) {
        return customerMapper.getCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        int row = customerMapper.updateCustomer(customer);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCustomers(String id) {
        int row = customerMapper.deleteCustomers(id);
        if (row > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getCustomerCondition(Param param) {
        List<Customer> customers = null;
        if (param.getCid() == 0) {
            if (param.getOrderby() == 1 || param.getOrderby() == 0){
                customers = customerMapper.getCustomerCondition(param);
            }else {
                customers = customerMapper.getCustomerConditionDESC(param);
            }
        }else if (param.getCid() == 1){
            if (param.getOrderby() == 1 || param.getOrderby() == 0){
                customers =customerMapper.getByComPanyAsc(param);
            }else {
                customers =customerMapper.getByComPanyDesc(param);
            }
        }else {
            if (param.getOrderby() == 1 || param.getOrderby() == 0){
                customers =customerMapper.getByPersonAsc(param);
            }else {
                customers =customerMapper.getByPersonDesc(param);
            }
        }
        return customers;
    }
}
