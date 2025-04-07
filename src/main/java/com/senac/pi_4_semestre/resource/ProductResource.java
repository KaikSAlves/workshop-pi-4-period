package com.senac.pi_4_semestre.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.senac.pi_4_semestre.model.Product;
import com.senac.pi_4_semestre.service.ProductService;

import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/product")
public class ProductResource {
    
    @Autowired
    private ProductService service;

    //post

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        product = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    //gets
    
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        Product product = service.findById(id);

        return ResponseEntity.ok().body(product);
    }

    //put

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody Product product) {
        product = service.update(id, product);

        return ResponseEntity.ok().body(product);
    }

    //delete

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
