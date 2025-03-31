package com.senac.pi_4_semestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.pi_4_semestre.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
