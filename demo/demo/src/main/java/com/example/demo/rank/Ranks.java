package com.example.demo.rank;

import jakarta.persistence.*;
import com.example.demo.customer.Customer;
import com.example.demo.text.text;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Ranks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Sử dụng ID tự động tăng
	private Long idRank; // Thay đổi thành kiểu Long hoặc Integer
	private String nameRank;
    
	@OneToOne(mappedBy = "rank")
	@JsonBackReference
    private Customer customer;  // Mối quan hệ One-to-One với Customer

	public Long getIdRank() {
		return idRank;
	}

	public void setIdRank(Long idRank) {
		this.idRank = idRank;
	}

	public String getNameRank() {
		return nameRank;
	}

	public void setNameRank(String nameRank) {
		this.nameRank = nameRank;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Ranks(Long idRank, String nameRank, Customer customer) {
		super();
		this.idRank = idRank;
		this.nameRank = nameRank;
		this.customer = customer;
	}

	public Ranks() {
		super();
	}

  
}
