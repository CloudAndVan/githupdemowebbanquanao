package com.example.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepository extends JpaRepository<Customer, String> {
}
