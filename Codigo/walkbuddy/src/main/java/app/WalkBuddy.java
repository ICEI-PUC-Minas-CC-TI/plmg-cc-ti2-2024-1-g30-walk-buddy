package app;

import static spark.Spark.*;
import spark.Filter;
import service.UsuarioService;

public class WalkBuddy {
	public static void main(String[] args) {

		after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });

		get("hello",(request, response)->"Hello!");
		get("abc",(request, response)->"def");
		get("test",(request, response)->UsuarioService.inserir(request, response));
	}
}