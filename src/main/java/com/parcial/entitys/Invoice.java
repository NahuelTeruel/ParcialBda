package com.parcial.entitys;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="invoices")
@Data
public class Invoice {
    @Id
    @Column(name="InvoiceId")
    @GeneratedValue(generator = "Invoice_gen")
    @TableGenerator(name = "Invoice_gen", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="invoices",
            initialValue=1, allocationSize=1)
    private Integer invoiceId;
    
    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customerId;

    @Column(name = "InvoiceDate")
    private LocalDateTime invoiceDate;

    @Column(name = "BillingAddress")
    private String billingAddress;

    @Column(name = "BillingCity")
    private String billingCity;

    @Column(name = "BillingState")
    private String billingState;

    @Column(name = "BillingCountry")
    private String billingCountry;

    @Column(name = "BillingPostalCode")
    private String billingPostalCode;

    @Column(name = "Total")
    private Float Total;

    @OneToMany(mappedBy = "invoiceId")
    @JsonIgnore
    private List<InvoiceItem> invoiceItems = new ArrayList<>();
}
