package com.i9.depreciation.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Depreciacao {

    private Long id;
    private double valorInicial;
    private double valorResidual;
    private int vidautil;
    private double depreciacaoAnual;

    public Depreciacao(double valorInicial, double valorResidual, int vidautil) {
    }

    public int getVidaUtil() {
        return vidautil;
    }
}
