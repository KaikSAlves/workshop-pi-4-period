package com.senac.pi_4_semestre.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.pi_4_semestre.model.Payment;
import com.senac.pi_4_semestre.service.PaymentService;

import io.micrometer.core.ipc.http.HttpSender.Response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/payment")
public class PaymentResource {
    

    @Autowired
    private PaymentService service;

    //post

    @PostMapping
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        payment = service.save(payment);

        return ResponseEntity.ok().body(payment) ;
    }

    //gets

    @GetMapping
    public ResponseEntity<List<Payment>> findAll() {
        List<Payment> payments = service.findAll();

        return ResponseEntity.ok().body(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Integer id) {
        Payment payment = service.findById(id);

        return ResponseEntity.ok().body(payment);
    }


    //put

    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(@PathVariable Integer id, @RequestBody Payment payment) {
        payment = service.update(id, payment);

        return ResponseEntity.ok().body(payment);
    }


    //delete

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
    
    
    
    
}
