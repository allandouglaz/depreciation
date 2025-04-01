package com.i9.depreciation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "depreciacao")
public class Depreciacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valorInicial;
    private double valorResidual;
    private int vidautil;
    private double depreciacaoAnual;

    public Depreciacao(double valorInicial, double valorResidual, int vidaUtil) {
    }
}

