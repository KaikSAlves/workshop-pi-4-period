package com.senac.pi_4_semestre.model;

import java.io.Serializable;

public class OderItem implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer id;

    private Order order;

    private Product product;

    private Integer qtd;
    
    public OderItem() {
    }

    public OderItem(Integer id, Order order, Product product, Integer qtd) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.qtd = qtd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }


}
