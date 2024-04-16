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

}
