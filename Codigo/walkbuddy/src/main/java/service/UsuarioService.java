package service;

import dao.UsuarioDAO;
import model.Usuario;
import spark.Request;
import spark.Response;

public class UsuarioService {
	
	public static String inserir(Request request, Response response) {
		String resultado = "erro";
		boolean sucesso = false;
		response.status(400);
		Usuario usuario = new Usuario();
		usuario.nome = request.queryParams("nome");
		usuario.senha = request.queryParams("senha");
		usuario.cpf = request.queryParams("cpf");
		sucesso = UsuarioDAO.inserir(usuario);
		if(sucesso) {
			resultado = "Usuario " + usuario.nome + " criado";
            response.status(201);
		}
		return resultado;
	}
}
