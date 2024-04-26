package dao;

import model.Usuario;
import java.sql.*;

public class UsuarioDAO {
	
	public static boolean inserir(Usuario usuario) {
		boolean status = false;
		try {
			Connection conexao = DAO.conectar();
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO usuario (email, senha, nome, cpf, foto, tipo, telefone1, telefone2) "
		               + "VALUES ('" + usuario.email + "', '" + usuario.senha + "', '" + usuario.nome
		               + "', '" + usuario.cpf + "', '" + usuario.foto + "', '" + usuario.tipo
		               + "', '" + usuario.telefone1 + "', '" + usuario.telefone2 + "');";
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (Exception e) {
			System.out.println("erro inserir");
		}
		return status;
	}

	public static Usuario procurarPorEmail(String email) {
		Usuario pesquisado = new Usuario();
		try {
			Connection conexao = DAO.conectar();
			Statement st = conexao.createStatement();
			String sql = "SELECT * FROM usuario WHERE email LIKE '" + email + "';";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				pesquisado.id = rs.getInt("id");
				pesquisado.email = rs.getString("email");
				pesquisado.senha = rs.getString("senha");
				pesquisado.tipo = rs.getString("tipo");
			}
			st.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pesquisado;
	}

	public static Usuario procurarPorId(int id) {
		Usuario pesquisado = new Usuario();
		try {
			Connection conexao = DAO.conectar();
			Statement st = conexao.createStatement();
			String sql = "SELECT * FROM usuario WHERE id = " + id + ";";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				pesquisado.id = id;
				pesquisado.nome = rs.getString("nome");
				pesquisado.email = rs.getString("email");
				pesquisado.foto = rs.getString("foto");
				pesquisado.tipo = rs.getString("tipo");
				pesquisado.telefone1 = rs.getString("telefone1");
			}
			st.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pesquisado;
	}

}
