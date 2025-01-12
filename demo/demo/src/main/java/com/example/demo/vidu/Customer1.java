package com.example.demo.vidu;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customer1 {

    @Id
    private String idCustomer; // Đổi tên thành idCustomer

    private String name;
    private String phoneNumber; // Đổi tên thành phoneNumber
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Order1> orders;

    @OneToMany(mappedBy = "customer")
    private List<Invoice1> invoices;

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

	public List<Order1> getOrders() {
		return orders;
	}

	public void setOrders(List<Order1> orders) {
		this.orders = orders;
	}

	public List<Invoice1> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice1> invoices) {
		this.invoices = invoices;
	}

	public Customer1(String idCustomer, String name, String phoneNumber, String email, List<Order1> orders,
			List<Invoice1> invoices) {
		super();
		this.idCustomer = idCustomer;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.orders = orders;
		this.invoices = invoices;
	}

	public Customer1() {
		super();
	}
    
    
}
