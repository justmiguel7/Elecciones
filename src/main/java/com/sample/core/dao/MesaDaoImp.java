package com.sample.core.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Mesa;
import com.sample.core.exceptions.ErrorException;

public class MesaDaoImp implements MesaDao {

	private Conexion conexion = Conexion.getInstance();


	    private static final String queryListByDni = 
	        "SELECT DISTINCT m.id_mesa, m.mesa, m.distrito, m.id_padron, m.orden " +
	        "FROM mesa m " +
	        "JOIN padron p ON p.distrito = m.distrito " +
	        "WHERE p.DNI = ?";

	    @Override
	    public List<Mesa> listByDni(int dni) throws Exception {
	        List<Mesa> mesas = new ArrayList<>();
	        ResultSet rs = null;
	        PreparedStatement st = null;

	        try {
	            st = conexion.dameConnection().prepareStatement(queryListByDni);
	            st.setInt(1, dni);
	            rs = st.executeQuery();

	            while (rs.next()) {
	                Mesa mesa = new Mesa(
	                    rs.getInt("id_mesa"),
	                    rs.getInt("mesa"),
	                    rs.getString("distrito"),
	                    rs.getInt("id_padron"),
	                    rs.getInt("orden")
	                );
	                mesas.add(mesa);
	            }
	        } catch (Exception e) {
	            throw new ErrorException("Error al obtener mesas por DNI", e);
	        } finally {
	            if (rs != null) rs.close();
	            if (st != null) st.close();
	        }

	        return mesas;
	    }

		@Override
		public List<Mesa> listByDistrito(String distrito) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Mesa> list() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		}