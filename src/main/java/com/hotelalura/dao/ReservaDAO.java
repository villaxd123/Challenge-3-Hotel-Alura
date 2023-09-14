package com.hotelalura.dao;

import com.hotelalura.model.Reserva;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    private final Connection connection;
    private String message;

    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Reserva> listar() {
        List<Reserva> listaReservas = new ArrayList<>();
        try {
            final PreparedStatement querySelect = connection.prepareStatement(
                    "SELECT id, fecha_entrada, fecha_salida, valor, forma_de_pago FROM reserva"
            );
            try (querySelect) {
                querySelect.execute();
                ResultSet resultSet = querySelect.getResultSet();
                while (resultSet.next()) {
                    listaReservas.add(new Reserva(
                            resultSet.getInt("id"),
                            resultSet.getString("fecha_entrada"),
                            resultSet.getString("fecha_salida"),
                            resultSet.getDouble("valor"),
                            resultSet.getString("forma_de_pago")
                    ));
                }
                resultSet.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaReservas;
    }

    public void editar(Integer id, String fechaIn, String fechaOut, Double valor, String tipoPago) {
        try {
            final PreparedStatement queryUpdate = connection.prepareStatement(
                    "UPDATE reserva SET " +
                            "fecha_entrada = ?, " +
                            "fecha_salida = ?, " +
                            "valor = ?, " +
                            "forma_de_pago = ? " +
                            "WHERE id = ? "
            );
            try (queryUpdate) {
                queryUpdate.setString(1, fechaIn);
                queryUpdate.setString(2, fechaOut);
                queryUpdate.setDouble(3, valor);
                queryUpdate.setString(4, tipoPago);
                queryUpdate.setInt(5, id);
                queryUpdate.execute();

                JOptionPane.showMessageDialog(null, "Reserva modificada con éxito.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, String.format("Error: %s", e.getMessage()));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Integer guardar(Integer id, String fechaEntrada, String fechaSalida, Double valor, String formaPago) {
        try {
            PreparedStatement queryInsert = connection.prepareStatement(
                    "INSERT INTO reserva " +
                            "(id, fecha_entrada, fecha_salida, valor, forma_de_pago) " +
                            "VALUES (?, ?, ?, ?, ?)"
            );
            try (queryInsert) {
                queryInsert.setInt(1, id);
                queryInsert.setString(2, fechaEntrada);
                queryInsert.setString(3, fechaSalida);
                queryInsert.setDouble(4, valor);
                queryInsert.setString(5, formaPago);
                queryInsert.execute();
                return queryInsert.getUpdateCount();
            } catch (Exception e) {
                this.message = e.getMessage();
                return 10;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public List<Reserva> buscar(Integer id) {
        List<Reserva> listaReservas = new ArrayList<>();
        try {
            PreparedStatement querySearch = connection.prepareStatement(
                    "SELECT id, fecha_entrada, fecha_salida, valor, forma_de_pago " +
                            "FROM reserva WHERE id = ?"
            );
            try (querySearch) {
                querySearch.setInt(1, id);
                querySearch.execute();
                ResultSet resultSet = querySearch.getResultSet();
                while (resultSet.next()) {
                    listaReservas.add(new Reserva(
                            resultSet.getInt("id"),
                            resultSet.getString("fecha_entrada"),
                            resultSet.getString("fecha_salida"),
                            resultSet.getDouble("valor"),
                            resultSet.getString("forma_de_pago")
                    ));
                }
                resultSet.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaReservas;
    }

    public void eliminar(Integer id) {
        try {
            PreparedStatement queryDelete = connection.prepareStatement(
                    "DELETE FROM reserva WHERE id = ?"
            );
            try (queryDelete) {
                queryDelete.setInt(1, id);
                queryDelete.execute();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            this.connection.close();
            System.out.println("ReservaDAO cerró su conexión a la base de datos");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getMessage() {
        return this.message;
    }
}
