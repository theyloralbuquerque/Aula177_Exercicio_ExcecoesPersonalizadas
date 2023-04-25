package model.entities;

import model.exceptions.DomainException;

public class Conta {

    private Integer numero;
    private String titular;
    private Double saldo;
    private Double limiteDeSaque;

    public Conta() {
    }

    public Conta(Integer numero, String titular, Double saldo, Double limiteDeSaque) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteDeSaque = limiteDeSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getLimiteDeSaque() {
        return limiteDeSaque;
    }

    public void setLimiteDeSaque(Double limiteDeSaque) {
        this.limiteDeSaque = limiteDeSaque;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void deposito(Double valor) {
        saldo += valor;
    }

    public void saque(Double valor) {
        if (valor > saldo) {
            throw new DomainException("Saldo insuficiente.");
        }
        else if (valor > limiteDeSaque) {
            throw new DomainException("O valor excede o limite de saque.");
        }
        else {
            saldo -= valor;
        }
    }

}