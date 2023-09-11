package com.hotelalura.controller;

import com.hotelalura.dao.ReservaDAO;
import com.hotelalura.factory.ConnectionFactory;
import com.hotelalura.model.Reserva;

import java.util.List;

public class ReservaController {
    private final ReservaDAO reservaDAO;

    public ReservaController() {
        ConnectionFactory factory = new ConnectionFactory();
        reservaDAO = new ReservaDAO(factory.getConnection());
    }

    public List<Reserva> listar() {
        return reservaDAO.listar();
    }
}
