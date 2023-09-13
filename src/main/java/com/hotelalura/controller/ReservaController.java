package com.hotelalura.controller;

import com.hotelalura.dao.ReservaDAO;
import com.hotelalura.factory.ConnectionFactory;
import com.hotelalura.model.Reserva;

import java.util.List;

public class ReservaController {
    private final ReservaDAO reservaDAO;
    private String message;

    public ReservaController() {
        ConnectionFactory factory = new ConnectionFactory();
        reservaDAO = new ReservaDAO(factory.getConnection());
    }

    public List<Reserva> listar() {
        return reservaDAO.listar();
    }

    public void editar(Integer id, String fechaIn, String fechaOut, Double valor, String tipoPago) {
        reservaDAO.editar(id, fechaIn, fechaOut, valor, tipoPago);
    }

    public Integer guardar(Integer id, String fechaEntrada, String fechaSalida, Double valor, String formaPago) {
        Integer value = reservaDAO.guardar(id, fechaEntrada, fechaSalida, valor, formaPago);
        if (value == 10) {
            this.message = reservaDAO.getMessage();
        }
        return value;
    }

    public void close() {
        reservaDAO.close();
    }

    public String getMessage() {
        return this.message;
    }
}
