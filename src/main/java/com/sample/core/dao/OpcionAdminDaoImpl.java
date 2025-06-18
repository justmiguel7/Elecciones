package com.sample.core.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.OpcionAdmin;

public class OpcionAdminDaoImpl implements OpcionAdminDao {

    private Conexion conexion = Conexion.getInstance();

    private static final String queryList = "SELECT id, titulo, descripcion, imagen_url, enlace_url FROM opciones_admin";

    @Override
    public List<OpcionAdmin> listarOpciones() throws Exception {
        List<OpcionAdmin> lista = new ArrayList<>();
        try (PreparedStatement stmt = conexion.dameConnection().prepareStatement(queryList);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                OpcionAdmin op = new OpcionAdmin(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("descripcion"),
                    rs.getString("imagen_url"),
                    rs.getString("enlace_url")
                );
                lista.add(op);
            }
        } catch (SQLException e) {
            throw new Exception("Error al listar opciones del administrador", e);
        }
        return lista;
    }
}