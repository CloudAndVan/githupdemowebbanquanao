package com.example.demo.vidu;

import jakarta.persistence.*;

@Entity
public class Order1 {
    @Id
    private String idOrder;

    private String orderDate;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer1 customer;

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
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

	public Order1(String idOrder, String orderDate, double totalAmount, Customer1 customer) {
		super();
		this.idOrder = idOrder;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.customer = customer;
	}

	public Order1() {
		super();
	}

    // Getters và Setters
   
}
