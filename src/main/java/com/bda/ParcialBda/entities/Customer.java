package com.bda.ParcialBda.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @Column(name = "CustomerId")
    @GeneratedValue(generator = "Customers")
    @TableGenerator(name = "Customers", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="customer",
            initialValue = 1, allocationSize = 1)
    private Integer customerId;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Company")
    private String company;
    @Column(name = "Address")
    private String address;
    @Column(name = "City")
    private String city;
    @Column(name = "State")
    private String state;
    @Column(name = "Country")
    private String country;
    @Column(name = "PostalCode")
    private String postalCode;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "Email")
    private String email;
    @Column(name = "SupportRepId")
    private Integer supportRepId;
}
