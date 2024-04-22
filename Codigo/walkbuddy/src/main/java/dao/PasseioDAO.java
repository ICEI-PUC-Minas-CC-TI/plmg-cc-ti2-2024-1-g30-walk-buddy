package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Passeio;

public class PasseioDAO {
	
	public static int inserir(Passeio passeio) {
		int idPasseio = 0;
		try {
			Connection conexao = DAO.conectar();
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO passeio (data, hora, estado, id_passeador) "
		               + "VALUES ('" + passeio.data + "', '" + passeio.hora + "', 'solicitado', ";
			if(passeio.idPasseador > 0)
				sql += passeio.idPasseador + ");";
			else
				sql += "null);";
			st.executeUpdate(sql);
			sql = "SELECT currval('passeio_id_seq');";
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			idPasseio = rs.getInt("currval");
			st.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return idPasseio;
	}
	
	public static boolean inserirPetPasseio(int passeioId, int petId) {
		boolean status = false;
		try {
			Connection conexao = DAO.conectar();
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO passeio_pet (id_passeio, id_pet) "
		               + "VALUES (" + passeioId + ", " + petId + ");";
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (Exception e) {
			System.out.println("erro inserir pet no passeio");
		}
		return status;
	}
	
	public static String listar() {
		String lista = "erro";
		String json;
		try {
			Connection conexao = DAO.conectar();
			Statement st = conexao.createStatement();
			String sql = "SELECT passeio.id AS passeioid, passeio.estado, passeio.data, passeio.hora, pet.nome AS nomePet, usuario.nome AS nomePasseador "+
				"FROM passeio JOIN passeio_pet ON passeio.id = passeio_pet.id_passeio "+
				"JOIN pet ON pet.id = passeio_pet.id_pet LEFT JOIN usuario ON usuario.id = passeio.id_passeador;";
			ResultSet rs = st.executeQuery(sql);
			lista = "[";
			while(rs.next()) {	            	
	        	json = "{";
	        	json += "\"id\": " + rs.getInt("passeioid") + ",";
	    		json += "\"data\": \"" + rs.getString("data") + "\",";
	    		json += "\"estado\": \"" + rs.getString("estado") + "\",";
	    		json += "\"hora\": \"" + rs.getString("hora") + "\",";
	    		json += "\"nomePet\": \"" + rs.getString("nomePet") + "\",";
	    		json += "\"nomePasseador\": \"" + rs.getString("nomePasseador") + "\"";
	    		json += "}";
	        	lista += json + ",";
	        }
			if(lista.charAt(lista.length()-1) == ',')
				lista = lista.substring(0, lista.length()-1);
			lista += "]";
			st.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	public static String aceitar(int idPasseio, int idPasseador) {
		String resultado = "erro";
		try {
			Connection conexao = DAO.conectar();
			Statement st = conexao.createStatement();
			String sql = "UPDATE passeio SET estado = 'aceito', id_passeador = " + idPasseador +
					" WHERE id = " + idPasseio + ";";
			st.executeUpdate(sql);
			st.close();
			conexao.close();
			resultado = "sucesso";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}

}
