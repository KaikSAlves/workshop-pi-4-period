package com.senac.pi_4_semestre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.pi_4_semestre.model.Product;
import com.senac.pi_4_semestre.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

     //create
    public Product save(Product product){
        return productRepository.save(product);
    }

    //read 
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Integer id){
        return productRepository.findById(id).orElse(null);
    }

    //update
    public Product update(Integer id, Product p2){
        Optional<Product> p1 = productRepository.findById(id);

        if(p1.isPresent()){
            updateData(p1.get(), p2);
        }

        return productRepository.save(p1.get());
    }

    private void updateData(Product p1, Product p2){
        p1.setDescription(p2.getDescription());
        p1.setImgUrl(p2.getImgUrl());
        p1.setName(p2.getName());
        p1.setPrice(p2.getPrice());

    }

    //delete

    public void delete(Integer id){
        Product u = productRepository.findById(id).orElse(null);
        productRepository.delete(u);
    }

}
