package com.hotelalura.dao;

import com.hotelalura.model.Cliente;

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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;
    }
}
