package com.parcial.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial.entitys.Customer;
import com.parcial.entitys.Invoice;
import com.parcial.entitys.Dtos.InvoiceDto;
import com.parcial.repositories.InvoiceRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class InvoiceServiceImpl implements InvoiceService{
    
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CustomerService customerService;
    
    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(Integer invoiceId) {
        return invoiceRepository.findById(invoiceId).orElseThrow();
    }

    @Override
    public Invoice delete(Integer invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow();
        invoiceRepository.delete(invoice);
        return invoice;
    }

    @Override
    public Invoice add(InvoiceDto entity) {
        Invoice invoice = new Invoice();

        Optional<Customer>  customer = Optional.of(customerService.findById(entity.getCustomerId()));

        if(customer.isPresent()){
            invoice.setCustomerId(customer.get());
        }else{
            throw new NoSuchElementException();
        }        
        invoice.setInvoiceDate(entity.getInvoiceDate());
        invoice.setBillingAddress(entity.getBillingAddress());
        invoice.setBillingCity(entity.getBillingCity());
        invoice.setBillingState(entity.getBillingState());
        invoice.setBillingCountry(entity.getBillingCountry());
        invoice.setBillingPostalCode(entity.getBillingPostalCode());
        invoice.setTotal(entity.getTotal());

        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice update(Integer id, InvoiceDto entity) {
        Optional<Invoice> invoice = Optional.of(invoiceRepository.findById(id).orElseThrow());

        Optional<Customer>  customer = Optional.of(customerService.findById(entity.getCustomerId()));

        if (invoice.isPresent() && customer.isPresent()){
            invoice.get().setCustomerId(customer.get());
            invoice.get().setInvoiceDate(entity.getInvoiceDate());
            invoice.get().setBillingAddress(entity.getBillingAddress());
            invoice.get().setBillingCity(entity.getBillingCity());
            invoice.get().setBillingState(entity.getBillingState());
            invoice.get().setBillingCountry(entity.getBillingCountry());
            invoice.get().setBillingPostalCode(entity.getBillingPostalCode());
            invoice.get().setTotal(entity.getTotal());

            return invoiceRepository.save(invoice.get());
        
        }
        else {
            throw new NoSuchElementException();
        }
    }
}
