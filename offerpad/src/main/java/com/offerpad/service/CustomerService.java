package com.offerpad.service;

import com.offerpad.userEntity.Customer;
import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> findAll();
    Customer findById(String customerId);
    void deleteById(String customerId);
    Customer update(Customer customer);
}
