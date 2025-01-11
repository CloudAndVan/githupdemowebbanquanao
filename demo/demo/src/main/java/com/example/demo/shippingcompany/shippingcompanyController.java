package com.example.demo.shippingcompany;

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
public class shippingcompanyController {

    @Autowired
    private shippingcompanyRepository shippingcompanyRepository;

    @GetMapping("/getAllshippingcompanys")
    public List<ShippingCompany> getAlltypes() {
        return shippingcompanyRepository.findAll();
    }

    @GetMapping("/getshippingcompanyById/{id}")
    public Optional<ShippingCompany> gettypeById(Long id) {
        return shippingcompanyRepository.findById(id);
    }
    
    @PostMapping("/saveOrUpdateshippingcompany")
    public void saveOrUpdatetype(@RequestBody ShippingCompany shippingcompany) {
    	shippingcompanyRepository.save(shippingcompany);
    }

    @PostMapping("/deleteshippingcompany")
    public void deletetype(@RequestBody Long id) {
    	shippingcompanyRepository.deleteById(id);
    }
}
