package com.example.demo.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class warehouseController {

    @Autowired
    private warehouseRepository warehouseRepository;

    @GetMapping("/getAllwarehouses")
    public List<Warehouse> getAllwarehouses() {
        return warehouseRepository.findAll();
    }

    @GetMapping("/getwarehouseById/{id}")
    public Optional<Warehouse> getwarehouseById(String id) {
        return warehouseRepository.findById(id);
    }
    
    @PostMapping("/saveOrUpdatewarehouse")
    public void saveOrUpdatewarehouse(@RequestBody Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    @PostMapping("/deletewarehouse")
    public void deletewarehouse(@RequestBody String id) {
        warehouseRepository.deleteById(id);
    }
}
