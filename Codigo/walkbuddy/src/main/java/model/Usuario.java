package model;

public class Usuario {
	public int id;
	public String email;
	public String senha;
	public String nome;
	public String cpf;
	public String foto;
	public String tipo;
	public String telefone1;
	public String telefone2;

	public String getPerfilData(){
		String json = "{";
		json += "\"nome\": \"" + this.nome + "\",";
		json += "\"email\": \"" + this.email + "\",";
		json += "\"foto\": \"" + this.foto + "\",";
		json += "\"tipo\": \"" + this.tipo + "\",";
		json += "\"telefone\": \"" + this.telefone1 + "\"";
		json += "}";
		return json;
	}
}
