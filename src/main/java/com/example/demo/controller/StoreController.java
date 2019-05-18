package com.example.demo.controller;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/stores")
    public List<Store> find() {
        return (List<Store>) storeRepository.findAll();
    }

    @PostMapping("/stores")
    void add(@RequestBody Store store) {
        storeRepository.save(store);
    }
}