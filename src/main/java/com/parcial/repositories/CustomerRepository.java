package com.parcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcial.entitys.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

