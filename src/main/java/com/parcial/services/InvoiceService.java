package com.parcial.services;

import java.util.List;

import com.parcial.entitys.Invoice;
import com.parcial.entitys.Dtos.InvoiceDto;

public interface InvoiceService {

    Invoice findById(Integer id);

    List<Invoice> findAll();

    Invoice delete(Integer id);

    Invoice update(Integer id, InvoiceDto entity);

    Invoice add(InvoiceDto entity);
}

