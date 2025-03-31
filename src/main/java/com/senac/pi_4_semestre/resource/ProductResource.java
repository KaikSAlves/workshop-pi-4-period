package com.senac.pi_4_semestre.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.pi_4_semestre.model.Product;
import com.senac.pi_4_semestre.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/product")
public class ProductResource {
    
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        product = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    
    
    
}
