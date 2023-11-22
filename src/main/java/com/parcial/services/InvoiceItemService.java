package com.parcial.services;


import com.parcial.entitys.Dtos.InvoiceItemDto;
import com.parcial.entitys.InvoiceItem;

import java.util.List;

public interface InvoiceItemService {
    InvoiceItem findById(Integer id);

    List<InvoiceItem> findAll();

    InvoiceItem delete(Integer id);

    InvoiceItem update(Integer id, InvoiceItemDto entity);

    InvoiceItem add(InvoiceItemDto entity);
}
