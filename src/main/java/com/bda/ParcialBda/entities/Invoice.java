package com.bda.ParcialBda.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
@Data
public class Invoice {
    @Id
    @Column(name = "InvoiceId")
    @GeneratedValue(generator = "Invoice")
    @TableGenerator(name = "Invoices", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="invoices",
            initialValue = 1, allocationSize = 1)
    private Integer idInvoice;

    /*@OneToOne(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CustomerId")
    @JsonBackReference
    private Integer customerId;*/

    @Column(name = "InvoiceDate")
    private LocalDateTime invoiceDate;

    @Column(name = "BillingAddress")
    private String billingAddress;

    @Column(name = "BillingCity")
    private String billingCity;

    @Column(name = "BillingState")
    private String billingState;

    @Column(name = "BillingCounty")
    private String billingCountry;

    @Column(name = "BillingPostalCode")
    private String billingPostalCode;

    @Column(name = "Total")
    private Float Total;

}
