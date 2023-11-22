package com.parcial.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;


@Entity
@Table(name="customers")
@Data
public class Customer {
    @Id
    @Column(name="CustomerId")
    @GeneratedValue(generator = "Customer_gen")
    @TableGenerator(name = "Customer_gen", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="customers",
            initialValue=1, allocationSize=1)
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

    @Column(name = "Fax")
    private String fax;

    @Column(name = "Email")
    private String email;

    @Column(name = "SupportRepId")
    private Integer supportRepId;
    

}
