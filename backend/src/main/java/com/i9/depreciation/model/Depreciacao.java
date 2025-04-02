package com.i9.depreciation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Depreciacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("valorInicial")
    private double valorInicial;

    @JsonProperty("valorResidual")
    private double valorResidual;

    @JsonProperty("vidaUtil")
    private int vidaUtil;

    // Construtor vazio necessário para a desserialização do JSON
    public Depreciacao() {}

    public Depreciacao(double valorInicial, double valorResidual, int vidaUtil) {
        this.valorInicial = valorInicial;
        this.valorResidual = valorResidual;
        this.vidaUtil = vidaUtil;
    }

    // Getters e Setters
    public double getValorInicial() { return valorInicial; }
    public void setValorInicial(double valorInicial) { this.valorInicial = valorInicial; }

    public double getValorResidual() { return valorResidual; }
    public void setValorResidual(double valorResidual) { this.valorResidual = valorResidual; }

    public int getVidaUtil() { return vidaUtil; }
    public void setVidaUtil(int vidaUtil) { this.vidaUtil = vidaUtil; }
}
