package service;

import dao.PasseioDAO;
import model.Passeio;
import spark.Request;
import spark.Response;

public class PasseioService {
	
	public static String inserir(Request request, Response response) {
		String resultado = "erro";
		boolean sucesso = false;
		response.status(400);
		Passeio passeio = new Passeio();
		passeio.data = request.queryParams("data");
		passeio.hora = request.queryParams("hora");
		if(request.queryParams("passeadorId").length()>0)
			passeio.idPasseador = Integer.parseInt(request.queryParams("passeadorId"));
		int idPasseio = PasseioDAO.inserir(passeio);
		sucesso = PasseioDAO.inserirPetPasseio(idPasseio,Integer.parseInt(request.queryParams("petId")));
		if(sucesso) {
			resultado = "Passeio adicionado";
            response.status(201);
		}
		return resultado;
	}
	
	public static String listar(Request request, Response response) {
		String resultado = "erro";
		resultado = PasseioDAO.listar();
        response.status(200);
		return resultado;
	}

	public static String aceitar(Request request, Response response) {
		String resultado = "erro";
		int idPasseio = Integer.parseInt(request.queryParams("idPasseio"));
		int idPasseador = Integer.parseInt(request.queryParams("idPasseador"));
		resultado = PasseioDAO.aceitar(idPasseio,idPasseador);
        response.status(200);
		return resultado;
	}

	public static String iniciar(Request request, Response response) {
		String resultado = "erro";
		int idPasseio = Integer.parseInt(request.queryParams("idPasseio"));
		int idPasseador = Integer.parseInt(request.queryParams("idPasseador"));
		resultado = PasseioDAO.iniciar(idPasseio,idPasseador);
        response.status(200);
		return resultado;
	}

	public static String finalizar(Request request, Response response) {
		String resultado = "erro";
		int idPasseio = Integer.parseInt(request.queryParams("idPasseio"));
		int idPasseador = Integer.parseInt(request.queryParams("idPasseador"));
		resultado = PasseioDAO.finalizar(idPasseio,idPasseador);
        response.status(200);
		return resultado;
	}

	public static String avaliar(Request request, Response response) {
		String resultado = "erro";
		int idPasseio = Integer.parseInt(request.queryParams("idPasseio"));
		int idPasseador = Integer.parseInt(request.queryParams("idPasseador"));
		resultado = PasseioDAO.avaliar(idPasseio,idPasseador);
        response.status(200);
		return resultado;
	}

}
