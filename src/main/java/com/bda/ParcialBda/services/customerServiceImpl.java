package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Customer;
import com.bda.ParcialBda.entities.dto.CustomerDto;
import com.bda.ParcialBda.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class customerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public customerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getById(Integer customerId) { return customerRepository.findById(customerId).orElseThrow();}

    @Override
    public List<Customer> findAll() {
            return customerRepository.findAll();}

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
        customer.setSupportRepld(entity.getSupportRepld());
        return customerRepository.save(customer);
    }

    @Override
    public Customer delete(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        customerRepository.delete(customer);
        return customer;
    }

    @Override
    public Customer modify(Integer customerId, CustomerDto entity) {
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
            customer.get().setSupportRepld(entity.getSupportRepld());
            return customerRepository.save(customer.get());}
        else {
            throw new NoSuchElementException("No existente en la Base de Datos");
        }
    }
}
