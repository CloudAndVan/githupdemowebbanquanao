package com.example.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class orderController {

    @Autowired
    private orderRepository orderRepository;

    @GetMapping("/getAllOrders")
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/getOrderById/{id}")
    public Optional<Orders> getOrderById(String id) {
        return orderRepository.findById(id);
    }
    
    @PostMapping("/saveOrUpdateOrder")
    public void saveOrUpdateOrder(@RequestBody Orders order) {
        orderRepository.save(order);
    }

    @PostMapping("/deleteOrder")
    public void deleteOrder(@RequestBody String id) {
        orderRepository.deleteById(id);
    }
}
