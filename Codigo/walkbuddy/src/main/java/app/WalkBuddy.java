package app;

import static spark.Spark.*;
import spark.Filter;
import service.*;

public class WalkBuddy {
	public static void main(String[] args) {

		after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });
		get("hello",(request, response)->"Hello!");

		//usuario
		post("usuario",(request, response)->UsuarioService.inserir(request, response));

		//pet
		post("pet",(request, response)->PetService.inserir(request, response));
		get("pet",(request, response)->PetService.listar(request, response));

		//passeio
		post("passeio",(request, response)->PasseioService.inserir(request, response));
		get("passeio",(request, response)->PasseioService.listar(request, response));
	}
}