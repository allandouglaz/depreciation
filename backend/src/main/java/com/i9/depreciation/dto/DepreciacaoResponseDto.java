package com.i9.depreciation.dto;

public class DepreciacaoResponseDto {
    private double depreciacaoAnual;
    private double valorFinal;
    private double valorInicial;
    private double valorResidual;
    private int vidaUtil;

    public DepreciacaoResponseDto(double depreciacaoAnual, double valorFinal, double valorInicial, double valorResidual) {
        this.depreciacaoAnual = depreciacaoAnual;
        this.valorFinal = valorFinal;
        this.valorInicial = valorInicial;
        this.valorResidual = valorResidual;
        this.vidaUtil = vidaUtil;
    }

    public double getDepreciacaoAnual() { return depreciacaoAnual; }
    public double getValorFinal() { return valorFinal; }
    public double getValorInicial() { return valorInicial; }
    public double getValorResidual() { return valorResidual; }
    public int getVidaUtil() { return vidaUtil; }
}

