package com.senac.pi_4_semestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.pi_4_semestre.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    
}
