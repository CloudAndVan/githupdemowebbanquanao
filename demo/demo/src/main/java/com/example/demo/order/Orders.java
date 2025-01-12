package com.example.demo.order;

import jakarta.persistence.*;
import com.example.demo.customer.Customer;
import com.example.demo.detailorder.DetailOrder;
import com.example.demo.invoice.Invoice;
import com.example.demo.shipping.Shipping;
import com.example.demo.text.text2;
import com.example.demo.text.text4;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
public class Orders {
    @Id
    private String idOrder; // Primary Key
    private String orderDate;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "idCustomer", referencedColumnName = "idCustomer")
    @JsonBackReference
    private Customer customer;
    
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Invoice invoice;
    

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailOrder> detailOrders; 
    
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}



	public List<DetailOrder> getDetailOrders() {
		return detailOrders;
	}

	public void setDetailOrders(List<DetailOrder> detailOrders) {
		this.detailOrders = detailOrders;
	}

	public Orders(String idOrder, String orderDate, double totalAmount, Customer customer, Invoice invoice,
			List<DetailOrder> detailOrders) {
		super();
		this.idOrder = idOrder;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.customer = customer;
		this.invoice = invoice;
		this.detailOrders = detailOrders;
	}

	

  
}
