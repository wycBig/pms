package com.ujiuye.cus.service;

import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.Param;

import java.util.List;

public interface CustomerService {

    boolean insertCustomer(Customer customer);

    List<Customer> getAllCustomer();

    Customer getCustomer(Integer id);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomers(String id);

    List<Customer> getCustomerCondition(Param param);
}
