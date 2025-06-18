package com.sample.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.VotoDao;
import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Voto;
import com.sample.core.domain.VotoResumen;
import com.sample.core.exceptions.ErrorException;

public class VotosDaoImp implements VotoDao {

    private Conexion conexion = Conexion.getInstance();

    private static final String QUERY_LIST =
        "SELECT * FROM votos";
    private static final String QUERY_FIND_BY_ID =
        "SELECT id_voto, DNI, id_presidente, id_vicepresidente, id_gobernador, id_mesa, fecha_hora FROM votos WHERE id_voto = ?";
    private static final String QUERY_ADD_VOTO =
        "INSERT INTO votos (DNI, id_candidato) VALUES (?, ?)";
    private static final String QUERY_DELETE_VOTO =
        "DELETE FROM votos WHERE id_voto = ?";

    private static final String QUERY_GUARDAR_VOTO = 
    	    "INSERT INTO votos (DNI, id_presidente, id_vicepresidente, id_gobernador, id_mesa) VALUES (?, ?, ?, ?, ?)";;

    private static final String BASE_QUERY_VOTOS_POR_PARTIDO =
    	    "SELECT c.partido, COUNT(*) AS cantidad_votos " +
    	    "FROM votos v JOIN candidatos c ON %s = c.id_candidato " +
    	    "WHERE c.rol = ? GROUP BY c.partido";
    
    
    
	private int DNI = 0;

	@Override
	public void guardarVoto(int id_padron, int presidente, int vicepresidente, int gobernador, int id_mesa) throws Exception {
	    try (Connection conn = conexion.dameConnection();
	         PreparedStatement st = conn.prepareStatement(QUERY_GUARDAR_VOTO)) {

	        st.setInt(1, id_padron);
	        st.setInt(2, presidente);
	        st.setInt(3, vicepresidente);
	        st.setInt(4, gobernador);
	        st.setInt(5, id_mesa);

	        int result = st.executeUpdate();
	        if (result == 0) {
	            throw new ErrorException("No se pudo guardar el voto.");
	        }
	    } catch (SQLException e) {
	        throw new ErrorException("Error al guardar el voto.", e);
	    }
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

	@Override
	public Voto findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voto> list() throws Exception {
	    ResultSet rs = null;
	    List<Voto> votos = null;
	    Voto producto = null;
	    PreparedStatement st = null;
	    try {
	        st = conexion.dameConnection().prepareStatement(QUERY_LIST);
	        rs = st.executeQuery();
	        votos = new ArrayList<Voto>();
	        while (rs.next()) {
	            Timestamp timestamp = rs.getTimestamp(7);
	            LocalDateTime fechaHora = null;
	            if (timestamp != null) {
	                fechaHora = timestamp.toLocalDateTime();
	            }
	            producto = new Voto(
	                rs.getInt(1),   // id_voto
	                rs.getInt(2),   // DNI
	                rs.getInt(3),   // id_presidente
	                rs.getInt(4),   // id_vicepresidente
	                rs.getInt(5),   // id_gobernador
	                rs.getInt(6),   //id_mesa
	                fechaHora      // fecha_Hora como LocalDateTime
	            );
	            votos.add(producto);
	        }

	    } catch (Exception e) {
	        throw new ErrorException("Hubo un error al realizar la consulta", e);
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (st != null) st.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return votos;
	}
	
	public List<VotoResumen> contarVotosPorPartido(String rol) throws Exception {
	    String columna;

	    switch (rol.toLowerCase()) {
	        case "presidente": columna = "v.id_presidente"; break;
	        case "vicepresidente": columna = "v.id_vicepresidente"; break;
	        case "gobernador": columna = "v.id_gobernador"; break;
	        default: throw new IllegalArgumentException("Rol inválido: " + rol);
	    }

	    String query = String.format(BASE_QUERY_VOTOS_POR_PARTIDO, columna);

	    List<VotoResumen> lista = new ArrayList<>();

	    try (Connection conn = conexion.dameConnection();
	         PreparedStatement st = conn.prepareStatement(query)) {

	        st.setString(1, rol.toLowerCase());
	        try (ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	                lista.add(new VotoResumen(rs.getString("partido"), rs.getInt("cantidad_votos")));
	            }
	        }

	    } catch (SQLException e) {
	        throw new ErrorException("Error al contar votos por partido para el rol: " + rol, e);
	    }

	    return lista;
	}
	
}
