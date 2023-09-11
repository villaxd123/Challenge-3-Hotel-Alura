package com.hotelalura.dao;

import com.hotelalura.model.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    private final Connection connection;

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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaReservas;
    }
}
