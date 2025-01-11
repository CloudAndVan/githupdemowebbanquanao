package com.example.demo.rank;

import jakarta.persistence.*;
import com.example.demo.customer.Customer;
import com.example.demo.text.text;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Ranks {
    @Id
    private String idRank; // Primary Key
    private String nameRank;
    
    @OneToOne
    @JoinColumn(name = "idCustomer") // Tham chiếu đến khóa chính của `text`
    private Customer customer;

	public String getIdRank() {
		return idRank;
	}

	public void setIdRank(String idRank) {
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

	public Ranks(String idRank, String nameRank, Customer customer) {
		super();
		this.idRank = idRank;
		this.nameRank = nameRank;
		this.customer = customer;
	}

	public Ranks() {
		super();
	}

  
}