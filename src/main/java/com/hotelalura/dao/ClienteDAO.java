package com.hotelalura.dao;

import com.hotelalura.model.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private final Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Cliente> listar() {
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            final PreparedStatement querySelect = connection.prepareStatement(
                    "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, celular, reserva_id FROM cliente"
            );
            try (querySelect) {
                querySelect.execute();
                ResultSet resultSet = querySelect.getResultSet();
                while (resultSet.next()) {
                    listaClientes.add(new Cliente(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido"),
                            resultSet.getString("fecha_nacimiento"),
                            resultSet.getString("nacionalidad"),
                            resultSet.getInt("celular"),
                            resultSet.getInt("reserva_id")
                    ));
                }
                resultSet.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaClientes;
    }

    public void editar(Integer id, String nombre, String apellido, String fechaNacimiento, String nacionalidad, Integer celular, Integer idReserva) {
        try {
            final PreparedStatement queryUpdate = connection.prepareStatement(
                    "UPDATE cliente SET " +
                            "nombre = ?, " +
                            "apellido = ?, " +
                            "fecha_nacimiento = ?, " +
                            "nacionalidad = ?, " +
                            "celular = ?, " +
                            "reserva_id = ? " +
                            "WHERE id = ?"
            );
            try (queryUpdate) {
                queryUpdate.setString(1, nombre);
                queryUpdate.setString(2, apellido);
                queryUpdate.setString(3, fechaNacimiento);
                queryUpdate.setString(4, nacionalidad);
                queryUpdate.setInt(5, celular);
                queryUpdate.setInt(6, idReserva);
                queryUpdate.setInt(7, id);
                queryUpdate.execute();

                JOptionPane.showMessageDialog(null, "Huésped modificado con éxito.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, String.format("Error: %s", e.getMessage()));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guardar(String nombre, String apellido, String fechaNacimiento, String nacionalidad, Integer celular, Integer reservaId) {
        try {
            PreparedStatement queryInsert = connection.prepareStatement(
                    "INSERT INTO cliente" +
                            "(nombre, apellido, fecha_nacimiento, nacionalidad, celular, reserva_id) " +
                            "VALUES (?, ?, ?, ?, ?, ?)"
            );
            try (queryInsert) {
                queryInsert.setString(1, nombre);
                queryInsert.setString(2, apellido);
                queryInsert.setString(3, fechaNacimiento);
                queryInsert.setString(4, nacionalidad);
                queryInsert.setInt(5, celular);
                queryInsert.setInt(6, reservaId);
                queryInsert.execute();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, String.format("Error: %s", e.getMessage()));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Cliente> buscarReserva(Integer idReserva) {
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            final PreparedStatement querySelect = connection.prepareStatement(
                    "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, celular, reserva_id FROM cliente " +
                            "WHERE reserva_id = ?"
            );
            try (querySelect) {
                querySelect.setInt(1, idReserva);
                querySelect.execute();
                ResultSet resultSet = querySelect.getResultSet();
                while (resultSet.next()) {
                    listaClientes.add(new Cliente(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido"),
                            resultSet.getString("fecha_nacimiento"),
                            resultSet.getString("nacionalidad"),
                            resultSet.getInt("celular"),
                            resultSet.getInt("reserva_id")
                    ));
                }
                resultSet.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaClientes;
    }

    public List<Cliente> buscarApellido(String apellido) {
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            final PreparedStatement querySelect = connection.prepareStatement(
                    "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, celular, reserva_id FROM cliente " +
                            "WHERE apellido = ?"
            );
            try (querySelect) {
                querySelect.setString(1, apellido);
                querySelect.execute();
                ResultSet resultSet = querySelect.getResultSet();
                while (resultSet.next()) {
                    listaClientes.add(new Cliente(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido"),
                            resultSet.getString("fecha_nacimiento"),
                            resultSet.getString("nacionalidad"),
                            resultSet.getInt("celular"),
                            resultSet.getInt("reserva_id")
                    ));
                }
                resultSet.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaClientes;
    }

    public void eliminarReserva(Integer idReserva) {
        try {
            PreparedStatement queryDelete = connection.prepareStatement(
                    "DELETE FROM cliente WHERE reserva_id = ?"
            );
            try (queryDelete) {
                queryDelete.setInt(1, idReserva);
                queryDelete.execute();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarCliente(Integer idCliente) {
        try {
            PreparedStatement queryDelete = connection.prepareStatement(
                    "DELETE FROM cliente WHERE id = ?"
            );
            try (queryDelete) {
                queryDelete.setInt(1, idCliente);
                queryDelete.execute();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
}
