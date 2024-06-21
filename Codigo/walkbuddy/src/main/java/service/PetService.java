package service;

import dao.PetDAO;
import model.Pet;
import spark.Request;
import spark.Response;


public class PetService {
	
	public static String inserir(Request request, Response response) {
		String resultado = "erro";
		boolean sucesso = false;
		response.status(400);
		Pet pet = new Pet();
		pet.nome = request.queryParams("nome");
		pet.dataNascimento = request.queryParams("dataNascimento");
		pet.raca = request.queryParams("raca");
		pet.perfilComportamental = request.queryParams("perfilComportamental");
		pet.idDono = Integer.parseInt(request.queryParams("idDono"));
		sucesso = PetDAO.inserir(pet);
		if(sucesso) {
			resultado = "Pet " + pet.nome + " adicionado";
            response.status(201);
		}
		return resultado;
	}
	
	public static String listar(Request request, Response response) {
		String resultado = "erro";
		int idDono = Integer.parseInt(request.queryParams("id_dono"));
		resultado = PetDAO.listar(idDono);
        response.status(200);
		return resultado;
	}

}
