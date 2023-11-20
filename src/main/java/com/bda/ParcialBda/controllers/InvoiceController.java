package com.bda.ParcialBda.controllers;

import com.bda.ParcialBda.entities.Invoice;
import com.bda.ParcialBda.entities.dto.InvoiceDto;
import com.bda.ParcialBda.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    @Autowired
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/todas")
    public ResponseEntity<List<Invoice>> findAll() {
        List<Invoice> invoices = invoiceService.findAll();
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getById(@PathVariable("id") Integer id) {
        try {
            Invoice invoice = invoiceService.getById(id);
            return ResponseEntity.ok(invoice);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Invoice> delete(@PathVariable("id") Integer id) {
        try {
            Invoice invoice = invoiceService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(invoice);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping
    public ResponseEntity<Invoice> add(@RequestBody InvoiceDto entity){
        try {
            Invoice invoice = invoiceService.add(entity);

            return ResponseEntity.status(HttpStatus.CREATED).body(invoice);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        catch (IndexOutOfBoundsException ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Invoice> modify(@PathVariable("id") Integer id,@RequestBody InvoiceDto entity) {
        try {
            Invoice invoice = invoiceService.modify(id, entity);

            return ResponseEntity.status(HttpStatus.OK).body(invoice);
        }
        catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
