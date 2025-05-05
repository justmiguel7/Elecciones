package com.sample.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Padron;
import com.sample.core.exceptions.ErrorException;

public class PadronDaoImp implements PadronDao{
	
	private Conexion conexion = Conexion.getInstance();
	
	private static final String queryList = "SELECT id_padron, DNI, distrito, ya_voto FROM padron";

    private static final String queryConsultarPadron = "SELECT DNI, id_usuario, distrito, ya_voto FROM padron WHERE id_padron = ?";

    private static final String queryAddPadron = "INSERT IGNORE INTO padron (DNI, distrito, ya_voto) VALUES (?, ?, ?)";

    private static final String queryDeletePadron = "DELETE FROM padron WHERE id_padron = ?";
    
    private static final String UpdatePadron = "UPDATE padron SET DNI = ?, distrito = ?, ya_voto = ? WHERE id_padron = ?";

    public List<Padron> list () throws Exception {
    	ResultSet rs = null;
		 List<Padron> padrones = null;
		 Padron producto = null;
		 PreparedStatement st = null;
		 try{
			 
			st = conexion.dameConnection().prepareStatement(queryList);
			rs = st.executeQuery();
			padrones = new ArrayList<Padron>();
			
			 while (rs.next()) {
				 producto = new Padron(rs.getInt(1),rs.getInt(2) , rs.getString(3), rs.getBoolean(4));
				 padrones.add(producto);
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
		 
		return padrones;
	}
    

	public Padron findById(int id) throws Exception {
		 ResultSet rs = null;
		 PreparedStatement st = null;
		 
		 try{
			st = conexion.dameConnection().prepareStatement(queryConsultarPadron);
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				return new Padron(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getBoolean(4));
			}

		 }catch (Exception e) {
				throw new ErrorException("Hubo un error al realizar la consulta", e);
		}finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	

	public void delete(int id) throws Exception {

		PreparedStatement st = this.conexion.dameConnection().prepareStatement(queryDeletePadron);
		st.setInt(1, id);
		int registros = st.executeUpdate();
		
		if (registros==0) {
			throw new Exception("hubo un error ");
		}		
		st.close();
	}
	
/*
	public void save(int id_usuario, String distrito, boolean ya_voto) throws Exception {
	
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			st = conexion.dameConnection().prepareStatement(queryAddPadron);		
			st.setInt(1, id_usuario);
			st.setString(2, distrito);
			st.setBoolean(3, ya_voto);
			int result= st.executeUpdate();
			if (result==0 ) {
				throw new Exception("hubo un error en base");
			}
		} catch (Exception e) {
			System.out.println(e.getCause());
		}finally {	
			finalizarConexion(st);
		}
		
	}
	*/
	
	public void save(int DNI, String distrito, boolean ya_voto) throws Exception {
	    PreparedStatement st = null;
	    Connection conn = null;
	    try {
	        conn = conexion.dameConnection(); // capturá la conexión para poder cerrarla
	        st = conn.prepareStatement(queryAddPadron);		
	        st.setInt(1, DNI);
	        st.setString(2, distrito);
	        st.setBoolean(3, ya_voto);
	        
	        int result = st.executeUpdate();
	        System.out.println("Filas insertadas: " + result);
	        
	        if (result == 0) {
	            throw new Exception("No se insertó ninguna fila en la base de datos");
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // mostrá el error real
	        throw e; // relanzá la excepción si querés que llegue al controller
	    } finally {
	        try {
	            if (st != null) st.close();
	            if (conn != null) conn.close(); // cerrá la conexión
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	private void finalizarConexion(PreparedStatement st) {
		try {
			if(st != null)st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void update(int id_padron, int DNI, String distrito, boolean ya_voto) throws Exception {
	    
	    PreparedStatement st = null;
	    Connection conn = null;
	    try {
	    	
	    	conn = conexion.dameConnection(); // capturá la conexión para poder cerrarla
	        st = conn.prepareStatement(UpdatePadron);	
	        st.setInt(1, id_padron);
	        st.setInt(2, DNI);
	        st.setString(3, distrito);
	        st.setBoolean(4, ya_voto);

	        st.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace(); // mostrá el error real
	        throw e; // relanzá la excepción si querés que llegue al controller
	    } finally {
	        try {
	            if (st != null) st.close();
	            if (conn != null) conn.close(); // cerrá la conexión
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

}
