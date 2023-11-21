package com.bda.ParcialBda.controllers;

import com.bda.ParcialBda.entities.Customer;
import com.bda.ParcialBda.entities.dto.CustomerDto;
import com.bda.ParcialBda.services.ArtistService;
import com.bda.ParcialBda.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/todos")
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") Integer id) {
        try {
            Customer customer = customerService.getById(id);
            return ResponseEntity.ok(customer);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") Integer id) {
        try {
            Customer customer = customerService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(customer);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping
    public ResponseEntity<Customer> add(@RequestBody CustomerDto entity){
        try {
            Customer customer = customerService.add(entity);

            return ResponseEntity.status(HttpStatus.CREATED).body(customer);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        catch (IndexOutOfBoundsException ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> modify(@PathVariable("id") Integer id,@RequestBody CustomerDto entity) {
        try {
            Customer customer = customerService.modify(id, entity);

            return ResponseEntity.status(HttpStatus.OK).body(customer);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
