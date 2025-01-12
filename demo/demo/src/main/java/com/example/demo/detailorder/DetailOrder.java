package com.example.demo.detailorder;

import jakarta.persistence.*;

import com.example.demo.order.Orders;
import com.example.demo.product.Product;
import com.example.demo.shipping.Shipping;
import com.example.demo.text.text2;

@Entity
@Table(name = "detail_order") // Định nghĩa rõ tên bảng
public class DetailOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailOrder;  // Primary key của bảng trung gian

    @ManyToOne
    @JoinColumn(name = "idOrder")
    private Orders order;  // Liên kết với bảng Order

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;  // Liên kết với bảng Product

    @OneToOne(mappedBy = "detailOrder", cascade = CascadeType.ALL)
    private Shipping shipping;
    
    private int quantity;  // Số lượng sản phẩm trong đơn hàng
    private double price;  // Giá của sản phẩm tại thời điểm đặt hàng

    // Getters và Setters
    public Orders getOrder() {
        return order;
    }
    public void setOrder(Orders order) {
        this.order = order;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Shipping getShipping() {
        return shipping;
    }
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Long getIdDetailOrder() {
        return idDetailOrder;
    }
    public void setIdDetailOrder(Long idDetailOrder) {
        this.idDetailOrder = idDetailOrder;
    }

    // Constructor không tham số (JPA yêu cầu)
    public DetailOrder() {}

    // Constructor đầy đủ
    public DetailOrder(Orders order, Product product, Shipping shipping, int quantity, double price) {
        this.order = order;
        this.product = product;
        this.shipping = shipping;
        this.quantity = quantity;
        this.price = price;
    }
}
