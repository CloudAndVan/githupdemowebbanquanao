package com.example.demo.text;

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
public class textController {

    @Autowired
    private textRepository textRepository;
    

    @PostMapping("/saveOrUpdatetext")
    public String saveOrUpdateCustomer(@RequestBody text customer) {
    	textRepository.save(customer);
    	return "yes";
    }
}
