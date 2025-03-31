package com.senac.pi_4_semestre.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import com.senac.pi_4_semestre.model.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private List<Product> products;
    private Double totalPrice;
    private LocalDateTime moment;
    private OrderStatus status;
    private Payment payment;
    
    public Order() {
    }

    public Order(List<Product> products, Double totalPrice, LocalDateTime moment, OrderStatus status,
            Payment payment) {
        this.products = products;
        this.totalPrice = totalPrice;
        this.moment = moment;
        this.status = status;
        this.payment = payment;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public LocalDateTime getMoment() {
        return moment;
    }
    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    

}
