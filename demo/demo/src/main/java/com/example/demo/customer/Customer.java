package com.example.demo.customer;

import jakarta.persistence.*;
import com.example.demo.order.Orders;
import com.example.demo.invoice.Invoice;
import com.example.demo.rank.Ranks;
import com.example.demo.text.text2;
import com.example.demo.text.text3;
import com.example.demo.vidu.Order1;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import aj.org.objectweb.asm.Type;

import java.util.List;

@Entity
public class Customer {
    @Id
    private String idCustomer; // Primary Key
    
    private String name;
    private String phoneNumber;
    private String email;
    private String account;
    private String password;

    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Ranks rank;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices;

	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Ranks getRank() {
		return rank;
	}

	public void setRank(Ranks rank) {
		this.rank = rank;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Customer(String idCustomer, String name, String phoneNumber, String email, String account, String password,
			List<Orders> orders, Ranks rank, List<Invoice> invoices) {
		super();
		this.idCustomer = idCustomer;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.account = account;
		this.password = password;
		this.orders = orders;
		this.rank = rank;
		this.invoices = invoices;
	}

	public Customer() {
		super();
	}

}
