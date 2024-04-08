package app;

import static spark.Spark.get;

import service.UsuarioService;

public class WalkBuddy {
	public static void main(String[] args) {
		get("hello",(request, response)->"Hello!");
		get("abc",(request, response)->"defgh");
		get("test",(request, response)->UsuarioService.inserir(request, response));
	}
}