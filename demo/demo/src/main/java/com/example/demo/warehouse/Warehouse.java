package com.example.demo.warehouse;

import jakarta.persistence.*;

import com.example.demo.detailwarehouse.DetailWarehouse;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
public class Warehouse {
    @Id
    private String idWarehouse; // Primary Key
    private String warehouseName;
    private String location;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<DetailWarehouse> detailWarehouses;  // Mối quan hệ với bảng trung gian DetailWarehouse

	public String getIdWarehouse() {
		return idWarehouse;
	}

	public void setIdWarehouse(String idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<DetailWarehouse> getDetailWarehouses() {
		return detailWarehouses;
	}

	public void setDetailWarehouses(List<DetailWarehouse> detailWarehouses) {
		this.detailWarehouses = detailWarehouses;
	}

	public Warehouse(String idWarehouse, String warehouseName, String location,
			List<DetailWarehouse> detailWarehouses) {
		super();
		this.idWarehouse = idWarehouse;
		this.warehouseName = warehouseName;
		this.location = location;
		this.detailWarehouses = detailWarehouses;
	}

	public Warehouse() {
		super();
	}

}
