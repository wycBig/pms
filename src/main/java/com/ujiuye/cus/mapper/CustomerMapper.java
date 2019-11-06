package com.ujiuye.cus.mapper;

import java.util.List;

import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.Param;

public interface CustomerMapper {

    int insertCustomer(Customer customer);

    List<Customer> getAllCustomer();

    Customer getCustomer(Integer id);

    int updateCustomer(Customer customer);

    int deleteCustomers(String id);


    List<Customer> getCustomerCondition(Param param);

    List<Customer> getCustomerConditionDESC(Param param);

    List<Customer> getByComPanyAsc(Param param);

    List<Customer> getByComPanyDesc(Param param);

    List<Customer> getByPersonAsc(Param param);

    List<Customer> getByPersonDesc(Param param);
}