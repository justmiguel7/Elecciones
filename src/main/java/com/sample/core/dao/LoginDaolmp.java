package com.sample.core.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Usuario;
import com.sample.core.exceptions.ErrorException;

public class LoginDaolmp implements LoginDao {
	
	
	private Conexion conexion = Conexion.getInstance();
	
	private static final String queryFindByUser = "SELECT id, correo, contrasena FROM administrador where correo = ?";

	private static final String queryFindByUserAndPassword = "SELECT id, correo, contrasena FROM administrador where correo = ? and contrasena = ?";

	private static final String queryList = "SELECT id, correo, contrasena FROM administrador";
	
	private static final String queryConsultarUsuario = "SELECT id, correo, contrasena FROM administrador where id=?";

	
	
	public List<Usuario> list() throws Exception {
		 ResultSet rs = null;
		 List<Usuario> Usuarios = null;
		 Usuario producto = null;
		 PreparedStatement st = null;
		 try{
			st = conexion.dameConnection().prepareStatement(queryList);
			rs = st.executeQuery();
			Usuarios = new ArrayList<Usuario>();
			 while (rs.next()) {
				 producto = new Usuario(rs.getInt(1),rs.getString(2), rs.getString(3));
				 Usuarios.add(producto);
			}
				
		 }catch (Exception e) {
				throw new ErrorException("Hubo un error al realizar la consulta", e);
		}finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 
		return Usuarios;
	}

	
	public Usuario findById(int id) throws Exception {
		 ResultSet rs = null;
		 PreparedStatement st = null;
		 try{
			st = conexion.dameConnection().prepareStatement(queryConsultarUsuario);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				return new Usuario(rs.getInt(1),rs.getString(2), rs.getString(3));
			}

		 }catch (Exception e) {
				throw new ErrorException("Hubo un error al realizar la consulta", e);
		}finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	
	private void finalizarConexion(PreparedStatement st) {
		try {
			if(st != null)st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void existeCorreo(String correo) throws Exception {
	    PreparedStatement st = null;
	    ResultSet rs = null;
	    try {
	        st = this.conexion.dameConnection().prepareStatement(queryFindByUser);
	        st.setString(1, correo);
	        rs = st.executeQuery();
	        boolean encontro = rs.next();

	        if (!encontro) {
	            throw new Exception("El usuario " + correo + " no existe en DB");
	        }
	    } catch (Exception e) {
	        throw new Exception("No existe el usuario", e);
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (st != null) st.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


	public void existeCorreoContrasena(String correo, String contrasena) throws Exception {
	    PreparedStatement st = null;
	    ResultSet rs = null;
	    try {
	        st = this.conexion.dameConnection().prepareStatement(queryFindByUserAndPassword);
	        st.setString(1, correo);
	        st.setString(2, contrasena);
	        rs = st.executeQuery();
	        boolean encontro = rs.next();

	        if (!encontro) {
	            throw new Exception("El usuario " + correo + " no coincide con la password");
	        }
	    } catch (Exception e) {
	        throw new Exception("login incorrecto", e);
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (st != null) st.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


	public void agregarReintento(String usuario) throws Exception {

		
		
		
	}



	
}
