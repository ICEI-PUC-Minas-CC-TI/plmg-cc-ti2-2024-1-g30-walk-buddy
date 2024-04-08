package dao;

import java.sql.*;

public class DAO {
	public static Connection conectar (){
		String url = "jdbc:postgresql://localhost:5432/banco";
		String username = "felipe";
		String password = "senha";
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
		}
		return conexao;
	}
	
	public boolean close(Connection conexao) {
		boolean status = false;
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
}