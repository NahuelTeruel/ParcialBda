package com.parcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcial.entitys.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}

