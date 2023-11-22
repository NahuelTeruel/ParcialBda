package com.parcial.entitys;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "invoice_items")
@Data
public class InvoiceItem {
    @Id
    @Column(name = "InvoiceLineId")
    @GeneratedValue(generator = "Items")
    @TableGenerator(name = "Items", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="invoice_items",
            initialValue = 1, allocationSize = 1)
    private Integer itemId;


    @ManyToOne
    @JoinColumn(name = "invoiceId")
    private Invoice invoiceId;


    @ManyToOne
    @JoinColumn(name = "trackId")
    private Track trackId;


    @Column(name = "UnitPrice")
    private Float unitPrice;

    @Column(name = "Quantity")
    private Integer quantity;
}
