package com.i9.depreciation.dto;

public class DepreciacaoDto {
    private double valorInicial;
    private double valorResidual;
    private int vidaUtil;

    public double getValorInicial() { return valorInicial; }
    public void setValorInicial(double valorInicial) { this.valorInicial = valorInicial; }
    public double getValorResidual() { return valorResidual; }
    public void setValorResidual(double valorResidual) { this.valorResidual = valorResidual; }
    public int getVidaUtil() { return vidaUtil; }
    public void setVidaUtil(int vidaUtil) { this.vidaUtil = vidaUtil; }

    public double getDepreciacaoAnual() {
        return (this.valorInicial - this.valorResidual) / this.vidaUtil;
    }

}
