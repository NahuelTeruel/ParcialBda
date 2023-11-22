package com.parcial.services;

import com.parcial.entitys.Dtos.InvoiceItemDto;
import com.parcial.entitys.Invoice;
import com.parcial.entitys.InvoiceItem;
import com.parcial.entitys.Track;
import com.parcial.repositories.InvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService{
    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private TrackService trackService;

    @Override
    public InvoiceItem findById(Integer id) {
        return invoiceItemRepository.findById(id).orElseThrow();
    }

    @Override
    public List<InvoiceItem> findAll() {
        return invoiceItemRepository.findAll();
    }

    @Override
    public InvoiceItem delete(Integer id) {
        InvoiceItem invoiceItem = invoiceItemRepository.findById(id).orElseThrow();
        invoiceItemRepository.delete(invoiceItem);
        return invoiceItem;
    }

    @Override
    public InvoiceItem update(Integer id, InvoiceItemDto entity) {
        Optional<InvoiceItem> invoiceItem = Optional.of(invoiceItemRepository.findById(id).orElseThrow());
        Optional<Invoice> invoice = Optional.of(invoiceService.findById(entity.getInvoiceId()));
        Optional<Track> track = Optional.of(trackService.findById(entity.getTrackId()));

        if(invoiceItem.isPresent() && invoice.isPresent()){
            invoiceItem.get().setInvoiceId(invoice.get());
            invoiceItem.get().setTrackId(track.get());
            invoiceItem.get().setQuantity(entity.getQuantity());
            invoiceItem.get().setUnitPrice(entity.getUnitPrice());
            return invoiceItemRepository.save(invoiceItem.get());
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public InvoiceItem add(InvoiceItemDto entity) {
        InvoiceItem invoiceItem = new InvoiceItem();
        Optional<Invoice> invoice = Optional.of(invoiceService.findById(entity.getInvoiceId()));
        Optional<Track> track = Optional.of(trackService.findById(entity.getTrackId()));

        if(invoice.isPresent() && track.isPresent()){
            invoiceItem.setInvoiceId(invoice.get());
            invoiceItem.setTrackId(track.get());
            invoiceItem.setQuantity(entity.getQuantity());
            invoiceItem.setUnitPrice(entity.getUnitPrice());
            return invoiceItemRepository.save(invoiceItem);
        } else {
            throw new NoSuchElementException("No existente en la Base de Datos");
        }

    }
}
