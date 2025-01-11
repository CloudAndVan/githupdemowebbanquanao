package com.example.demo.vidu;

import jakarta.persistence.*;
import com.example.demo.customer.Customer;
import com.example.demo.payment.PaymentReceipt;
import com.example.demo.order.Orders;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
public class Invoice1 {
    @Id
    private String idInvoice; // Primary Key
    
    private String invoiceDate;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer1 customer;

	public String getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(String idInvoice) {
		this.idInvoice = idInvoice;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Customer1 getCustomer() {
		return customer;
	}

	public void setCustomer(Customer1 customer) {
		this.customer = customer;
	}

	public Invoice1(String idInvoice, String invoiceDate, double totalAmount, Customer1 customer) {
		super();
		this.idInvoice = idInvoice;
		this.invoiceDate = invoiceDate;
		this.totalAmount = totalAmount;
		this.customer = customer;
	}

	public Invoice1() {
		super();
	}

}
