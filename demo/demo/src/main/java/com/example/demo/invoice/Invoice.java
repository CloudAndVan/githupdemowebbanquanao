package com.example.demo.invoice;

import jakarta.persistence.*;
import com.example.demo.customer.Customer;
import com.example.demo.payment.PaymentReceipt;
import com.example.demo.text.text;
import com.example.demo.order.Orders;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
public class Invoice {
    @Id
    private String idInvoice; // Primary Key
    private String invoiceDate;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "idCustomer")
    @JsonBackReference
    private Customer customer;
    
    @OneToOne
    @JoinColumn(name = "idOrder") // Tham chiếu đến khóa chính của `text`
    private Orders order;
    
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentReceipt> paymentReceipts;

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public List<PaymentReceipt> getPaymentReceipts() {
		return paymentReceipts;
	}

	public void setPaymentReceipts(List<PaymentReceipt> paymentReceipts) {
		this.paymentReceipts = paymentReceipts;
	}

	public Invoice(String idInvoice, String invoiceDate, double totalAmount, Customer customer, Orders order,
			List<PaymentReceipt> paymentReceipts) {
		super();
		this.idInvoice = idInvoice;
		this.invoiceDate = invoiceDate;
		this.totalAmount = totalAmount;
		this.customer = customer;
		this.order = order;
		this.paymentReceipts = paymentReceipts;
	}

	
   
}
