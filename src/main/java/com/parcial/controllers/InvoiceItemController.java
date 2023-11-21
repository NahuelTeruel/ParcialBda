package com.parcial.controllers;

import com.parcial.entitys.Album;
import com.parcial.entitys.Dtos.AlbumDto;
import com.parcial.entitys.Dtos.InvoiceItemDto;
import com.parcial.entitys.InvoiceItem;
import com.parcial.services.InvoiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/")
public class InvoiceItemController {
    @Autowired
    private InvoiceItemService invoiceItemService;

    @GetMapping("/invoiceItem")
    public ResponseEntity<List<InvoiceItem>> findInvoiceItem(){
        try {
            List<InvoiceItem> invoiceItems = invoiceItemService.findAll();
            return ResponseEntity.ok(invoiceItems);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/invoiceItem")
    public ResponseEntity<InvoiceItem> addInvoiceItem(@RequestBody InvoiceItemDto entity) {
        try{
            InvoiceItem invoiceItem = invoiceItemService.add(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(invoiceItem);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/invoiceItem/{id}")
    public ResponseEntity<InvoiceItem> updateInvoiceItem(@PathVariable Integer id, @RequestBody InvoiceItemDto entity) {
        try{
            InvoiceItem invoiceItem = invoiceItemService.update(id, entity);
            return ResponseEntity.ok(invoiceItem);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/invoiceItem/{id}")
    public ResponseEntity<InvoiceItem> deleteInvoiceItem(@PathVariable Integer id) {
        try{
            InvoiceItem invoiceItem = invoiceItemService.delete(id);
            return ResponseEntity.ok(invoiceItem);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/invoiceItem/{id}")
    public ResponseEntity<InvoiceItem> getInvoiceItem(@PathVariable Integer id) {
        try{
            InvoiceItem invoiceItem = invoiceItemService.findById(id);
            return ResponseEntity.ok(invoiceItem);
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
