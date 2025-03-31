package com.senac.pi_4_semestre.model.enums;

public enum PaymentType {
    PIX("Pix"),
    CREDIT_CARD("Cartão de crédito"),
    DEBIT_CARD("Cartão de débito"),
    MONEY("Dinheiro");

    private final String descricao;

    private PaymentType(String descricao){
        this.descricao = descricao;
    }
}
