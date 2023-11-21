package com.parcial.entitys.Dtos;

import com.parcial.entitys.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemDto {

    private Integer invoiceId;

    private Integer trackId;

    private Float unitPrice;

    private Integer quantity;
    
}
