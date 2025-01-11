package com.example.demo.type;

import jakarta.persistence.*;
import java.util.List;

import com.example.demo.product.Product;

@Entity
public class Type {
    @Id
    private String idType;  // Mã loại sản phẩm
    private String name;    // Tên loại sản phẩm

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;  // Liên kết với bảng Product, một loại có thể có nhiều sản phẩm

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Type(String idType, String name, List<Product> products) {
		super();
		this.idType = idType;
		this.name = name;
		this.products = products;
	}

    // Getters và Setters
  
}
