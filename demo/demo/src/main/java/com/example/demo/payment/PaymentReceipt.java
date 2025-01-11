package com.example.demo.payment;

import jakarta.persistence.*;
import com.example.demo.invoice.Invoice;
import com.example.demo.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PaymentReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaymentReceipt;  // Primary Key

    private String receiptDate;
    private double amountPaid;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "idInvoice", referencedColumnName = "idInvoice")
    private Invoice invoice;  // The invoice that this payment receipt is associated with

    @ManyToOne
    @JoinColumn(name = "idProduct", referencedColumnName = "idProduct")
    private Product product;  // The invoice that this payment receipt is associated with

	public Long getIdPaymentReceipt() {
		return idPaymentReceipt;
	}

	public void setIdPaymentReceipt(Long idPaymentReceipt) {
		this.idPaymentReceipt = idPaymentReceipt;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PaymentReceipt(Long idPaymentReceipt, String receiptDate, double amountPaid, int quantity, Invoice invoice,
			Product product) {
		super();
		this.idPaymentReceipt = idPaymentReceipt;
		this.receiptDate = receiptDate;
		this.amountPaid = amountPaid;
		this.quantity = quantity;
		this.invoice = invoice;
		this.product = product;
	}

    
    // Getters and Setters
   
}
