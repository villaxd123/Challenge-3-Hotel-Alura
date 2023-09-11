package com.hotelalura.controller;

import com.hotelalura.dao.ClienteDAO;
import com.hotelalura.factory.ConnectionFactory;
import com.hotelalura.model.Cliente;

import java.util.List;

public class ClienteController {
    private final ClienteDAO clienteDAO;

    public ClienteController() {
        ConnectionFactory factory = new ConnectionFactory();
        clienteDAO = new ClienteDAO(factory.getConnection());
    }

    public List<Cliente> listar() {
        return clienteDAO.listar();
    }
}
