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

	public static String login(Request request, Response response) {
		String resultado = "erro";
		response.status(400);
		Usuario usuarioRequest = new Usuario();
		usuarioRequest.email = request.queryParams("email");
		usuarioRequest.senha = request.queryParams("senha");
		Usuario usuarioBanco = UsuarioDAO.procurarPorEmail(usuarioRequest.email);
		if(usuarioRequest.email.equals(usuarioBanco.email) && usuarioRequest.senha.equals(usuarioBanco.senha)) {
			resultado = "{\"idUsuario\":" + usuarioBanco.id + ",\"tipoUsuario\":\""+ usuarioBanco.tipo +"\"}";
            response.status(200);
		}
		else {
			resultado = "Usuário não encontrado";
            response.status(404);
		}
		return resultado;
	}
}
