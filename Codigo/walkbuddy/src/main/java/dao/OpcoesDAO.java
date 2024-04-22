package dao;

import java.sql.*;

public class OpcoesDAO {
	
	public static String getPets() {
		String lista = "erro";
		try {
			Connection conexao = DAO.conectar();
			Statement st = conexao.createStatement();
			String sql = "SELECT id, nome FROM pet;";
			ResultSet rs = st.executeQuery(sql);
			lista = "[";
			while(rs.next()) {	            	
				lista += "{\"id\":" + rs.getInt("id") + ",";
				lista += "\"nome\":\"" + rs.getString("nome") + "\"},";
	        }
			if(lista.charAt(lista.length()-1)==',')
				lista = lista.substring(0, lista.length()-1);
			lista += "]";
			st.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	public static String getPasseador() {
		String lista = "erro";
		try {
			Connection conexao = DAO.conectar();
			Statement st = conexao.createStatement();
			String sql = "SELECT id, nome FROM usuario WHERE tipo = 'passeador';";
			ResultSet rs = st.executeQuery(sql);
			lista = "[";
			while(rs.next()) {	            	
				lista += "{\"id\":" + rs.getInt("id") + ",";
				lista += "\"nome\":\"" + rs.getString("nome") + "\"},";
	        }
			if(lista.charAt(lista.length()-1)==',')
				lista = lista.substring(0, lista.length()-1);
			lista += "]";
			st.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

}
