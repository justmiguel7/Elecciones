package com.sample.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.LoginCiudadano;
import com.sample.core.domain.Plato;
import com.sample.core.exceptions.ErrorException;

public class LoginCiudadanoDaoImp implements LoginCiudadanoDao {

	private Conexion conexion = Conexion.getInstance();

	private static final String queryFindByDNI = "SELECT DNI FROM Ciudadano where DNI = ? ";

	private static final String queryList = "SELECT DNI FROM Ciudadano";

	private static final String queryConsultarList = "SELECT DNI, nombre, apellido, sexo, nacionalidad, direccion, cp, localidad, telefono FROM ciudadano";

	public List<LoginCiudadano> list() throws Exception {
		ResultSet rs = null;
		List<LoginCiudadano> ciudadanos = null;
		LoginCiudadano producto = null;
		PreparedStatement st = null;
		try {
			st = conexion.dameConnection().prepareStatement(queryConsultarList);
			rs = st.executeQuery();
			ciudadanos = new ArrayList<LoginCiudadano>();
			while (rs.next()) {
				producto = new LoginCiudadano(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
				ciudadanos.add(producto);
			} 

		} catch (Exception e) {
			throw new ErrorException("Hubo un error al realizar la consulta", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return ciudadanos;
	}

	private void finalizarConexion(PreparedStatement st) {
		try {
			if (st != null)
				st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}                                                                                                     

	public void existeDNI(int DNI) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = this.conexion.dameConnection().prepareStatement(queryFindByDNI);
			st.setInt(1, DNI);
			rs = st.executeQuery();
			boolean encontro = rs.next();

			if (!encontro) {
				throw new Exception("El dni " + DNI + " no existe en DB");
			}
		} catch (Exception e) {
			throw new Exception("No existe el dni", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void agregarReintento(int DNI) throws Exception {

	}

}
