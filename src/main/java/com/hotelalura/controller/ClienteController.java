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

    public void editar(Integer id, String nombre, String apellido, String fechaNacimiento, String nacionalidad, Integer celular, Integer idReserva) {
        clienteDAO.editar(id, nombre, apellido, fechaNacimiento, nacionalidad, celular, idReserva);
    }

    public void guardar(String nombre, String apellido, String fechaNacimiento, String nacionalidad, Integer celular, Integer reservaId) {
        clienteDAO.guardar(nombre, apellido, fechaNacimiento, nacionalidad, celular, reservaId);
    }

    public List<Cliente> buscarReserva(Integer idReserva) {
        return clienteDAO.buscarReserva(idReserva);
    }

    public List<Cliente> buscarApellido(String apellido) {
        return clienteDAO.buscarApellido(apellido);
    }

    public void eliminarReserva(Integer idReserva) {
        clienteDAO.eliminarReserva(idReserva);
    }

    public void eliminarCliente(Integer idCliente) {
        clienteDAO.eliminarCliente(idCliente);
    }

    public void close() {
        clienteDAO.close();
    }
}
