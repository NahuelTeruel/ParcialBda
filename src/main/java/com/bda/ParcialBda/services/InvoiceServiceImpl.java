package com.bda.ParcialBda.services;

import com.bda.ParcialBda.entities.Invoice;
import com.bda.ParcialBda.entities.dto.InvoiceDto;
import com.bda.ParcialBda.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    private final InvoiceRepository invoiceRepository;
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository){this.invoiceRepository = invoiceRepository;}
    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getById(Integer invoiceId) {
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
        invoice.setCustomerId(entity.getCustomerId());
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
    public Invoice modify(Integer id, InvoiceDto entity) {
        Optional<Invoice> invoice = Optional.of(invoiceRepository.findById(id).orElseThrow());
        if (invoice.isPresent()){
            invoice.get().setCustomerId(entity.getCustomerId());
            invoice.get().setInvoiceDate(entity.getInvoiceDate());
            invoice.get().setBillingAddress(entity.getBillingAddress());
            invoice.get().setBillingCity(entity.getBillingCity());
            invoice.get().setBillingState(entity.getBillingState());
            invoice.get().setBillingCountry(entity.getBillingCountry());
            invoice.get().setBillingPostalCode(entity.getBillingPostalCode());
            invoice.get().setTotal(entity.getTotal());
            return invoiceRepository.save(invoice.get());}
        else {
            throw new NoSuchElementException("No existente en la Base de Datos");
        }
    }
}
