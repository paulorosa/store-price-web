package com.example.demo.controller;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class StoreController {

    @Autowired
    private final StoreRepository storeRepository;

    @GetMapping("/stores")
    public List<Store> find() {
        return (List<Store>) storeRepository.findAll();
    }

    @PostMapping("/stores")
    void add(@RequestBody Store store) {
        storeRepository.save(store);
    }
}