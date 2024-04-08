package dao;

import model.Usuario;
import java.sql.*;

public class UsuarioDAO {
	
	public static boolean inserir(Usuario usuario) {
		boolean status = false;
		try {
			Connection conexao = DAO.conectar();
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO usuarios (nome, senha, cpf) "
		               + "VALUES ('" + usuario.nome + "', '"
		               + usuario.senha + "', '" + usuario.cpf + "');";
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (Exception e) {
			System.out.println("erro inserir");
		}
		return status;
	}

}
