package com.example.demo.shippingcompany;

import jakarta.persistence.*;

@Entity
@Table(name = "shipping_company")
public class ShippingCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shipping_company")
    private Long idShippingCompany; // Primary key

    @Column(name = "company_name")
    private String companyName; // Name of the shipping company

    @Column(name = "phone_number")
    private String phoneNumber; // Contact number of the shipping company

    @Column(name = "shipping_fee")
    private String shippingFee; // Base shipping fee for the company

    // Getters and Setters
    public Long getIdShippingCompany() {
        return idShippingCompany;
    }

    public void setIdShippingCompany(Long idShippingCompany) {
        this.idShippingCompany = idShippingCompany;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(String shippingFee) {
        this.shippingFee = shippingFee;
    }

    // Constructor
    public ShippingCompany(String companyName, String phoneNumber, String shippingFee) {
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.shippingFee = shippingFee;
    }
}
