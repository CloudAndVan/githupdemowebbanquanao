package com.example.demo.customer;

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
import com.example.demo.vidu.Customer1;

@RestController
@CrossOrigin(origins = "*")
public class customerController {

    @Autowired
    private customerRepository customerRepository;
    
    @Autowired
    private ranksRepository ranksRepository;
    
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/getAllRanks")
    public List<Ranks> getAllRanks() {
        return ranksRepository.findAll();
    }
    
    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.status(404).body(null); // Nếu không tìm thấy khách hàng
        }
    }

    @PostMapping(value = "/saveOrUpdateCustomer", consumes = "application/json")
    public void saveOrUpdateCustomer(@RequestBody Customer customer) {
        // Tìm kiếm Customer trong cơ sở dữ liệu
        Optional<Customer> existingCustomer = customerRepository.findById(customer.getIdCustomer());

        if (existingCustomer.isPresent()) {
            // Nếu Customer đã tồn tại, giữ nguyên Rank hiện tại
            customer.setRank(existingCustomer.get().getRank());
            ranksRepository.save(existingCustomer.get().getRank());
        } else {
            // Nếu Customer chưa tồn tại, tạo Rank mới
            Ranks newRank = new Ranks();
            newRank.setNameRank("Default Rank");
            customer.setRank(newRank);
            ranksRepository.save(newRank);
        }
        // Lưu hoặc cập nhật Customer
        customerRepository.save(customer);
    }
    
    @PostMapping("/updateCustomerRank/{customerId}/{newRankName}")
    public void updateCustomerRank(
            @PathVariable String customerId, 
            @PathVariable String newRankName) {
        
        // Tìm kiếm Customer trong cơ sở dữ liệu
        Optional<Customer> existingCustomer = customerRepository.findById(customerId);

        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();

            // Tìm Rank mới dựa trên tên hoặc tạo mới nếu không tồn tại
            Ranks newRank = ranksRepository.findByRankName(newRankName).orElseGet(() -> {
                Ranks rank = new Ranks();
                rank.setNameRank(newRankName);
                return ranksRepository.save(rank); // Lưu Rank mới
            });

            // Cập nhật Rank của Customer
            customer.setRank(newRank);
            customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer không tồn tại với ID: " + customerId);
        }
    }


    @PostMapping("/deleteCustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
            return ResponseEntity.status(200).body("Customer deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Customer not found.");
        }
    }
}
