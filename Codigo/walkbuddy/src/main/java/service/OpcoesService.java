package service;

import dao.OpcoesDAO;
import spark.Request;
import spark.Response;

public class OpcoesService {
	
	public static String getOpcoes(Request request, Response response) {
		String resultado = "{";
		
		if(request.queryParams("pet").equals("sim"))
			resultado += "\"pet\":" + OpcoesDAO.getPets()+ ",";
		if(request.queryParams("passeador").equals("sim"))
			resultado +=  "\"passeador\":" + OpcoesDAO.getPasseador()+ ",";
		
		if(resultado.charAt(resultado.length()-1)==',')
			resultado = resultado.substring(0, resultado.length()-1);
		resultado += "}";

        response.status(200);
		return resultado;
	}

}
