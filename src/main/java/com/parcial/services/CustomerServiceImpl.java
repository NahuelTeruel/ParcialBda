package com.parcial.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.parcial.entitys.Customer;
import com.parcial.entitys.Dtos.CustomerDto;
import com.parcial.repositories.CustomerRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findById(Integer customerId) {
        return customerRepository.findById(customerId).orElseThrow();
    }

    @Override
    public List<Customer> findAll() {
            return customerRepository.findAll();
    }

    @Override
    public Customer add(CustomerDto entity) {
        Customer customer = new Customer();
        customer.setFirstName(entity.getFirstName());
        customer.setLastName(entity.getLastName());
        customer.setCompany(entity.getCompany());
        customer.setAddress(entity.getAddress());
        customer.setCity(entity.getCity());
        customer.setState(entity.getState());
        customer.setCountry(entity.getCountry());
        customer.setPostalCode(entity.getPostalCode());
        customer.setPhone(entity.getPhone());
        customer.setFax(entity.getFax());
        customer.setEmail(entity.getEmail());
        customer.setSupportRepId(entity.getSupportRepld());
        return customerRepository.save(customer);
    }

    @Override
    public Customer delete(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        customerRepository.delete(customer);
        return customer;
    }

    @Override
    public Customer update(Integer customerId, CustomerDto entity) {
        Optional<Customer> customer = Optional.of(customerRepository.findById(customerId).orElseThrow());
        if (customer.isPresent()){
            customer.get().setFirstName(entity.getFirstName());
            customer.get().setLastName(entity.getLastName());
            customer.get().setCompany(entity.getCompany());
            customer.get().setAddress(entity.getAddress());
            customer.get().setCity(entity.getCity());
            customer.get().setState(entity.getState());
            customer.get().setCountry(entity.getCountry());
            customer.get().setPostalCode(entity.getPostalCode());
            customer.get().setPhone(entity.getPhone());
            customer.get().setFax(entity.getFax());
            customer.get().setEmail(entity.getEmail());
            customer.get().setSupportRepId(entity.getSupportRepld());
            return customerRepository.save(customer.get());}
        else {
            throw new NoSuchElementException("No existente en la Base de Datos");
        }
    }
}
