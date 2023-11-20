package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Customer;
import com.bda.ParcialBda.entities.Genre;
import com.bda.ParcialBda.entities.dto.CustomerDto;
import com.bda.ParcialBda.entities.dto.GenreDto;

import java.util.List;

public interface CustomerService {
    Customer getById(Integer customerId);
    List<Customer> findAll();
    Customer add(CustomerDto entity);
    Customer delete(Integer customerId);
    Customer modify(Integer customerId, CustomerDto entity);
}
