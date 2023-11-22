package com.parcial.controllers;

import com.parcial.entitys.Invoice;
import com.parcial.entitys.Dtos.InvoiceDto;
import com.parcial.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<Invoice>> findInvoice(){
        try {
            List<Invoice> invoices = invoiceService.findAll();
            return ResponseEntity.ok(invoices);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping
    public ResponseEntity<Invoice> addInvoice(@RequestBody InvoiceDto entity) {
        try{
            Invoice invoice = invoiceService.add(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(invoice);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable("id")Integer id, @RequestBody InvoiceDto entity){
        try {
            Invoice invoice = invoiceService.update(id, entity);
            return ResponseEntity.ok(invoice);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Invoice> deleteInvoice(@PathVariable("id")Integer id){
        try{
            Invoice invoice = invoiceService.delete(id);
            return ResponseEntity.ok(invoice);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") Integer id){
        try {
            Invoice invoice = invoiceService.findById(id);
            return ResponseEntity.ok(invoice);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
