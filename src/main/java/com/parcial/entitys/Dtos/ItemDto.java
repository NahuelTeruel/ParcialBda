package com.parcial.entitys.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private Integer invoiceId;

    private Integer trackId;

    private Float unitPrice;

    private Integer quantity;
    
}
