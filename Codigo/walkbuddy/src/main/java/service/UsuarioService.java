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
		usuario.email = request.queryParams("email");
		usuario.senha = request.queryParams("senha");
		usuario.nome = request.queryParams("nome");
		usuario.cpf = request.queryParams("cpf");
		usuario.foto = request.queryParams("foto");
		usuario.tipo = request.queryParams("tipo");
		usuario.telefone1 = request.queryParams("telefone1");
		usuario.telefone2 = request.queryParams("telefone2");
		sucesso = UsuarioDAO.inserir(usuario);
		if(sucesso) {
			resultado = "Usuario " + usuario.nome + " criado";
            response.status(201);
		}
		return resultado;
	}
}
