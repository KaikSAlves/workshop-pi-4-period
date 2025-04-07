package com.senac.pi_4_semestre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.pi_4_semestre.model.Payment;
import com.senac.pi_4_semestre.repository.PaymentRepository;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository r;

    //create

    public Payment save(Payment payment){
        return r.save(payment);
    }

    //read

    public List<Payment> findAll(){
        return r.findAll();
    }


    public Payment findById(Integer id){
        return r.findById(id).orElse(null);
    }

    //update

    public Payment update(Integer id, Payment payment){
        Payment obj = r.findById(id).orElse(null);

        updateData(obj, payment);

        return r.save(obj);
    }


    private void updateData(Payment p1, Payment p2){
        p1.setMoment(p2.getMoment());
        p1.setPaid(p2.isPaid());
        p1.setPaymentType(p2.getPaymentType());
    }

    //delete

    public void delete(Integer id){
        r.deleteById(id);
    }
}
