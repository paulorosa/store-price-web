package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;

@Service
public class StoreService {
    
    @Autowired
    private StoreRepository repository;

    public Iterable<Store> findAll() {
        return repository.findAll();
    }

    public Optional<Store> findById(Long id) {
        return repository.findById(id);
    }

    public Store save(Store store) {
        return repository.save(store);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}