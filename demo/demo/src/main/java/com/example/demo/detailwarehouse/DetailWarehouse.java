package com.example.demo.detailwarehouse;

import jakarta.persistence.*;
import com.example.demo.product.Product;
import com.example.demo.warehouse.Warehouse;


@Entity
public class DetailWarehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key của bảng trung gian

    @ManyToOne
    @JoinColumn(name = "idWarehouse", referencedColumnName = "idWarehouse")
    private Warehouse warehouse;  // Liên kết với bảng Warehouse

    @ManyToOne
    @JoinColumn(name = "idProduct", referencedColumnName = "idProduct")
    private Product product;  // Liên kết với bảng Product

    private int quantity;  // Số lượng sản phẩm trong kho

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public DetailWarehouse(Long id, Warehouse warehouse, Product product, int quantity) {
		super();
		this.id = id;
		this.warehouse = warehouse;
		this.product = product;
		this.quantity = quantity;
	}

    // Getters và Setters
    
}
