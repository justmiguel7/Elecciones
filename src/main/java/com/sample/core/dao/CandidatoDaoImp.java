package com.sample.core.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sample.core.dao.CandidatoDao;
import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Candidato;
import com.sample.core.enums.RolEnum;
import com.sample.core.exceptions.ErrorException;

public class CandidatoDaoImp implements CandidatoDao {

    private Conexion conexion = Conexion.getInstance();

    private static final String QUERY_LIST = "SELECT id_candidato, DNI, nombre_candidato, apellido_candidato, sexo_candidato, partido, rol FROM candidatos";
    
    private static final String QUERY_FIND_BY_ID =
        "SELECT id_candidato,DNI, nombre_candidato, apellido_candidato, sexo_candidato, partido FROM candidatos WHERE id_candidato = ?";

    private static final String QUERY_FORMULA_PRESIDENCIAL = "SELECT * FROM candidatos WHERE partido = ? AND rol IN ('presidente', 'vicepresidente')";
    
    private static final String QUERY_PARTIDOS_FORMULA = "SELECT DISTINCT partido FROM candidatos WHERE rol IN ('presidente', 'vicepresidente')";
    
    private static final String QUERY_GOBERNADORES = "SELECT * FROM candidatos WHERE rol = ('gobernador')";
    
    private  static final String QUERY_IMAGENES = "SELECT id_candidato, imagen_candidato FROM candidatos";
    
    
	public List<Candidato> list() throws Exception {
		 ResultSet rs = null;
		 List<Candidato> candidatos = null;
		 Candidato producto = null;
		 PreparedStatement st = null;
		 try{
			st = conexion.dameConnection().prepareStatement(QUERY_LIST);
			rs = st.executeQuery();
			candidatos = new ArrayList<Candidato>();
			 while (rs.next()) {
				 producto = new Candidato(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), RolEnum.obtenerRol(rs.getString(7)), null);
				 candidatos.add(producto);
			}
				
		 }catch (Exception e) {
				throw new ErrorException("Hubo un error al realizar la consulta", e);
		}finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 
		return candidatos;
	}

	public Candidato findById(int id) throws Exception {
	    try (Connection conn = conexion.dameConnection();
	         PreparedStatement st = conn.prepareStatement(QUERY_FIND_BY_ID)) {

	        st.setInt(1, id);
	        try (ResultSet rs = st.executeQuery()) {
	            if (rs.next()) {
	                return new Candidato(
	                         rs.getInt("id_candidato"),
	                         rs.getInt("DNI"),
	                         rs.getString("nombre_candidato"),
	                         rs.getString("apellido_candidato"),
	                         rs.getString("sexo_candidato"),
	                         rs.getString("partido"),
	                         RolEnum.obtenerRol(rs.getString("rol")), null
	                );
	            }
	        }
	    } catch (SQLException e) {
	        throw new ErrorException("Hubo un error al consultar el voto con id " + id, e);
	    }
	    return null;
	}

	@Override
	public List<Candidato> listarImagenes() throws Exception {
	    List<Candidato> candidatos = new ArrayList<>();
	    String sql = "SELECT id_candidato, DNI, nombre_candidato, apellido_candidato, sexo_candidato, partido, rol, imagen_candidato FROM candidatos";
	    try (PreparedStatement st = conexion.dameConnection().prepareStatement(sql)) {
	        ResultSet rs = st.executeQuery();
	        while (rs.next()) {
	            Candidato c = new Candidato(
	                rs.getInt("id_candidato"),
	                rs.getInt("DNI"),
	                rs.getString("nombre_candidato"),
	                rs.getString("apellido_candidato"),
	                rs.getString("sexo_candidato"),
	                rs.getString("partido"),
	                RolEnum.valueOf(rs.getString("rol").toUpperCase()),   
	                rs.getString("imagen_candidato") 
	            );
	            candidatos.add(c);
	        }
	    }
	    return candidatos;
	}
    }

	
    
    
    
    
    
    
    
    
    /*
   
    public List<String> obtenerPartidosConFormula() {
        List<String> partidos = new ArrayList<>();
        String sql = "SELECT DISTINCT partido FROM candidato WHERE cargo IN ('presidente', 'vicepresidente')";

        try (Connection conn = conexion.dameConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                partidos.add(rs.getString("partido"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return partidos;
    }
    
    

    // NUEVO METODO PARA FORMULAS PRESIDENCIALES
    public List<Candidato> obtenerFormulasPresidencialesPorPartido() throws ErrorException {
        List<Candidato> formulas = new ArrayList<>();
        List<String> partidos = new ArrayList<>();

        try (Connection conn = conexion.dameConnection();
             PreparedStatement stPartidos = conn.prepareStatement(QUERY_PARTIDOS_FORMULA);
             ResultSet rsPartidos = stPartidos.executeQuery()) {

            while (rsPartidos.next()) {
                partidos.add(rsPartidos.getString("partido"));
            }

            for (String partido : partidos) {
                try (PreparedStatement stFormula = conn.prepareStatement(QUERY_FORMULA_PRESIDENCIAL)) {
                    stFormula.setString(1, partido);
                    try (ResultSet rs = stFormula.executeQuery()) {
                        while (rs.next()) {
                            Candidato c = new Candidato(
                                rs.getInt("id_candidato"),
                                rs.getInt("DNI"),
                                rs.getString("nombre_candidato"),
                                rs.getString("apellido_candidato"),
                                rs.getString("sexo_candidato"),
                                rs.getString("partido")
                            );
                            formulas.add(c);
                        }
                    }
                }
            }

        } catch (Exception e) {
            throw new ErrorException("Hubo un error al obtener las formulas presidenciales", e);
        }

        return formulas;
    }

    public List<Candidato> obtenerGobernadores() throws Exception {
        List<Candidato> gobernadores = new ArrayList<>();
        
        try (Connection conn = conexion.dameConnection();
             PreparedStatement st = conn.prepareStatement(QUERY_GOBERNADORES);
             ResultSet rs = st.executeQuery()) {
            
            while (rs.next()) {
                Candidato c = new Candidato(
                    rs.getInt("id_candidato"),
                    rs.getInt("DNI"),
                    rs.getString("nombre_candidato"),
                    rs.getString("apellido_candidato"),
                    rs.getString("sexo_candidato"),
                    rs.getString("partido")
                );
                gobernadores.add(c);
            }

        } catch (Exception e) {
            throw new ErrorException("Error al obtener gobernadores", e);
        }

        return gobernadores;
    }
    
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

