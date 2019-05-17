package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private final ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> find() {
        return (List<Product>) productRepository.findAll();
    }

    @PostMapping("/products")
    void add(@RequestBody Product product) {
        productRepository.save(product);
    }
}