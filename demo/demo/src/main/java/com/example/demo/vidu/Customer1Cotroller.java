package com.example.demo.vidu;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import com.example.demo.order.Orders;
import com.example.demo.rank.Ranks;
import com.example.demo.rank.ranksRepository;

@RestController
@CrossOrigin(origins = "*")
public class Customer1Cotroller {

    @Autowired
    private Customer1Repository customer1Repository;

    @GetMapping("/getAllCustomer1s")
    public List<Customer1> getAllCustomer1s() {
        return customer1Repository.findAll();
    }

    @GetMapping("/getCustomer1ById/{id}")
    public ResponseEntity<Customer1> getCustomer1ById(@PathVariable String id) {
        Optional<Customer1> Customer1 = customer1Repository.findById(id);
        
        if (Customer1.isPresent()) {
            return ResponseEntity.ok(Customer1.get());
        } else {
            return ResponseEntity.status(404).body(null); // Nếu không tìm thấy khách hàng
        }
    }

    @PostMapping(value = "/saveOrUpdateCustomer1", consumes = "application/json")
    public void saveOrUpdateCustomer1(@RequestBody Customer1 Customer1) {
        customer1Repository.save(Customer1);
    }



    @PostMapping("/deleteCustomer1/{id}")
    public ResponseEntity<String> deleteCustomer1(@PathVariable String id) {
        Optional<Customer1> Customer1 = customer1Repository.findById(id);
        
        if (Customer1.isPresent()) {
            customer1Repository.deleteById(id);
            return ResponseEntity.status(200).body("Customer1 deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Customer1 not found.");
        }
    }
}
