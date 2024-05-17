package app;

import static spark.Spark.*;
import spark.Filter;
import service.*;

public class WalkBuddy {
	public static void main(String[] args) {

		after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "*");
        });
		get("hello",(request, response)->"Hello!");

		//usuario
		post("usuario",(request, response)->UsuarioService.inserir(request, response));
		post("login",(request, response)->UsuarioService.login(request, response));
		get("perfil",(request, response)->UsuarioService.getPerfilData(request, response));

		//pet
		post("pet",(request, response)->PetService.inserir(request, response));
		get("pet",(request, response)->PetService.listar(request, response));

		//passeio
		post("passeio",(request, response)->PasseioService.inserir(request, response));
		post("passeio/aceitar",(request, response)->PasseioService.aceitar(request, response));
		post("passeio/iniciar",(request, response)->PasseioService.iniciar(request, response));
		post("passeio/finalizar",(request, response)->PasseioService.finalizar(request, response));
		post("passeio/avaliar",(request, response)->PasseioService.avaliar(request, response));
		get("passeio",(request, response)->PasseioService.listar(request, response));

		//opcoes
		post("opcoes",(request, response)->OpcoesService.getOpcoes(request, response));
	}
}
