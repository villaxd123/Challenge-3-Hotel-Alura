package com.hotelalura.model;

public class Cliente {
    private final Integer id;
    private final String nombre, apellido, fechaNacimiento, nacionalidad;
    private final Integer celular, reservaId;

    public Cliente(Integer id, String nombre, String apellido, String fechaNacimiento, String nacionalidad, Integer celular, Integer reservaId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.reservaId = reservaId;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Integer getCelular() {
        return celular;
    }

    public Integer getReservaId() {
        return reservaId;
    }
}
