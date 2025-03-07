package com.hotelalura.model;

public class Reserva {
    private final Integer id;
    private final String fechaEntrada, fechaSalida, formaPago;
    private final Double valor;

    public Reserva(Integer id, String fechaEntrada, String fechaSalida, Double valor, String formaPago) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.valor = valor;
        this.formaPago = formaPago;
    }

    public Integer getId() {
        return id;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public Double getValor() {
        return valor;
    }

    public String getFormaPago() {
        return formaPago;
    }
}
