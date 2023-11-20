package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Invoice;
import com.bda.ParcialBda.entities.dto.InvoiceDto;

import java.util.List;

public interface InvoiceService {
    List<Invoice> findAll();

    Invoice getById(Integer invoiceId);

    Invoice delete(Integer invoiceId);

    Invoice add(InvoiceDto entity);

    Invoice modify(Integer id, InvoiceDto entity);
}
