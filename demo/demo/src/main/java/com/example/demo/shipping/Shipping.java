package com.example.demo.shipping;
import jakarta.persistence.*;
import com.example.demo.detailorder.DetailOrder;
import com.example.demo.shippingcompany.ShippingCompany; // Import ShippingCompany class

@Entity
@Table(name = "shipping")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shipping")
    private Long idShipping; // Primary key

    @ManyToOne
    @JoinColumn(name = "shipping_company_id", referencedColumnName = "id_shipping_company", nullable = false)
    private ShippingCompany shippingCompany; // Many-to-One relationship với ShippingCompany

    @Column(name = "phone_number")
    private String phoneNumber; // Số điện thoại của công ty giao hàng

    @OneToOne
    @JoinColumn(name = "id_detail_order")
    private DetailOrder detailOrder;

    // Getters và Setters
    public Long getIdShipping() {
        return idShipping;
    }
    public void setIdShipping(Long idShipping) {
        this.idShipping = idShipping;
    }
    public ShippingCompany getShippingCompany() {
        return shippingCompany;
    }
    public void setShippingCompany(ShippingCompany shippingCompany) {
        this.shippingCompany = shippingCompany;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
	public DetailOrder getDetailOrder() {
		return detailOrder;
	}
	public void setDetailOrder(DetailOrder detailOrder) {
		this.detailOrder = detailOrder;
	}
   
}

