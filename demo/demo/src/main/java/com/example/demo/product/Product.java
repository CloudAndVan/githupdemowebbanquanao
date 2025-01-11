package com.example.demo.product;
import jakarta.persistence.*;
import java.util.List;
import com.example.demo.detailorder.DetailOrder;
import com.example.demo.detailwarehouse.DetailWarehouse;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.example.demo.type.Type;

@Entity
public class Product {
    @Id
    private String idProduct; 
    private String name;
    private double price;
    private String detail;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailOrder> detailOrders;  // Mối quan hệ với bảng trung gian DetailOrder
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailWarehouse> detailWarehouses;  // Mối quan hệ với bảng trung gian DetailWarehouse
    
    @ManyToOne
    @JoinColumn(name = "idType", referencedColumnName = "idType")
    private Type type;  // Mối quan hệ với bảng Type, mỗi sản phẩm có một loại

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List<DetailOrder> getDetailOrders() {
		return detailOrders;
	}

	public void setDetailOrders(List<DetailOrder> detailOrders) {
		this.detailOrders = detailOrders;
	}

	public List<DetailWarehouse> getDetailWarehouses() {
		return detailWarehouses;
	}

	public void setDetailWarehouses(List<DetailWarehouse> detailWarehouses) {
		this.detailWarehouses = detailWarehouses;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Product(String idProduct, String name, double price, String detail, List<DetailOrder> detailOrders,
			List<DetailWarehouse> detailWarehouses, Type type) {
		super();
		this.idProduct = idProduct;
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.detailOrders = detailOrders;
		this.detailWarehouses = detailWarehouses;
		this.type = type;
	}

    // Getters và Setters
   
}
