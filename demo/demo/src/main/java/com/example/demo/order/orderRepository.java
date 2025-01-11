package com.example.demo.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepository extends JpaRepository<Orders, String> {
}
