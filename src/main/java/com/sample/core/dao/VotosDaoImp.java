package com.sample.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.VotosDao;
import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Voto;
import com.sample.core.exceptions.ErrorException;

public class VotosDaoImp implements VotosDao {

    private Conexion conexion = Conexion.getInstance();

    private static final String QUERY_LIST =
        "SELECT id_voto, DNI, id_candidato, fecha_hora FROM votos";
    private static final String QUERY_FIND_BY_ID =
        "SELECT id_voto, DNI, id_candidato, fecha_hora FROM votos WHERE id_voto = ?";
    private static final String QUERY_ADD_VOTO =
        "INSERT INTO votos (DNI, id_candidato) VALUES (?, ?)";
    private static final String QUERY_DELETE_VOTO =
        "DELETE FROM votos WHERE id_voto = ?";

	private int DNI = 0;

    @Override
    public List<Voto> list() throws Exception {
        List<Voto> votos = new ArrayList<>();
        try (Connection conn = conexion.dameConnection();
             PreparedStatement st = conn.prepareStatement(QUERY_LIST);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Voto voto = new Voto(
                    rs.getInt("id_voto"),
                    rs.getInt("DNI"),
                    rs.getInt("id_candidato"),
                    rs.getTimestamp("fecha_hora").toLocalDateTime()
                );
                votos.add(voto);
            }
        } catch (SQLException e) {
            throw new ErrorException("Hubo un error al realizar la consulta de listado de votos", e);
        }
        return votos;
    }

    @Override
    public Voto findById(int id) throws Exception {
        try (Connection conn = conexion.dameConnection();
             PreparedStatement st = conn.prepareStatement(QUERY_FIND_BY_ID)) {

            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new Voto(
                        rs.getInt("id_voto"),
                        rs.getInt("DNI"),
                        rs.getInt("id_candidato"),
                        rs.getTimestamp("fecha_hora").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            throw new ErrorException("Hubo un error al consultar el voto con id " + id, e);
        }
        return null;
    }

    @Override
    public void save(int id_usuario, int id_candidato) throws Exception {
        try (Connection conn = conexion.dameConnection();
             PreparedStatement st = conn.prepareStatement(QUERY_ADD_VOTO)) {

            st.setInt(1, DNI);
            st.setInt(2, id_candidato);

            int result = st.executeUpdate();
            if (result == 0) {
                throw new ErrorException("No se insertó ninguna fila en la base de datos");
            }
        } catch (SQLException e) {
            throw new ErrorException("Error al guardar el voto", e);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try (Connection conn = conexion.dameConnection();
             PreparedStatement st = conn.prepareStatement(QUERY_DELETE_VOTO)) {

            st.setInt(1, id);
            int rows = st.executeUpdate();
            if (rows == 0) {
                throw new ErrorException("No se encontró un voto para eliminar con id " + id);
            }
        } catch (SQLException e) {
            throw new ErrorException("Error al eliminar el voto con id " + id, e);
        }
    }
}
