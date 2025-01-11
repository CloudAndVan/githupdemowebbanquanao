package com.example.demo.type;

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
public class typeController {

    @Autowired
    private typeRepository typeRepository;

    @GetMapping("/getAlltypes")
    public List<Type> getAlltypes() {
        return typeRepository.findAll();
    }

    @GetMapping("/gettypeById/{id}")
    public Optional<Type> gettypeById(String id) {
        return typeRepository.findById(id);
    }
    
    @PostMapping("/saveOrUpdatetype")
    public void saveOrUpdatetype(@RequestBody Type type) {
        typeRepository.save(type);
    }

    @PostMapping("/deletetype")
    public void deletetype(@RequestBody String id) {
        typeRepository.deleteById(id);
    }
}
