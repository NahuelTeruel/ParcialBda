package com.bda.ParcialBda.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "invoice_items")
@Data
public class Item {
    @Id
    @Column(name = "InvoiceLineId")
    @GeneratedValue(generator = "Items")
    @TableGenerator(name = "Items", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="items",
            initialValue = 1, allocationSize = 1)
    private Integer itemId;

    /*
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "invoices")
    @JsonBackReference
    private List<Invoice> invoices;
    private Integer invoiceId;
    */
    /*
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tracks")
    @JsonManagedReference
    private List<Track> tracks;
    private Integer trackId;
    */

    @Column(name = "UnitPrice")
    private Float unitPrice;

    @Column(name = "Quantity")
    private Integer quantity;
}