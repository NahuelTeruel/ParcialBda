package com.parcial.controllers;

import com.parcial.entitys.Customer;
import com.parcial.entitys.Dtos.CustomerDto;
import com.parcial.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findCustomer(){
        try {
            List<Customer> customers = customerService.findAll();
            return ResponseEntity.ok(customers);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDto entity) {
        try{
            Customer customer = customerService.add(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(customer);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id")Integer id, @RequestBody CustomerDto entity){
        try {
            Customer customer = customerService.update(id, entity);
            return ResponseEntity.ok(customer);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id")Integer id){
        try{
            Customer customer = customerService.delete(id);
            return ResponseEntity.ok(customer);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id){
        try {
            Customer customer = customerService.findById(id);
            return ResponseEntity.ok(customer);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
