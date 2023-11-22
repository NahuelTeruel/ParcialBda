package com.parcial.services;

import java.util.List;

import com.parcial.entitys.Customer;
import com.parcial.entitys.Dtos.CustomerDto;

public interface CustomerService {

    Customer findById(Integer id);

    List<Customer> findAll();

    Customer delete(Integer id);

    Customer update(Integer id, CustomerDto entity);

    Customer add(CustomerDto entity);
}

