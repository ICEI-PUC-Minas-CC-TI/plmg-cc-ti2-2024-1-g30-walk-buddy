package model;

public class Pet {
	public int id;
	public String nome;
	public String dataNascimento;
	public String raca;
	public String perfilComportamental;
	public String foto;
	public int idDono;

	public String toString() {
		String json = "{";
		json += "\"id\": " + this.id + ",";
		json += "\"nome\": \"" + this.nome + "\",";
		json += "\"dataNascimento\": \"" + this.dataNascimento + "\",";
		json += "\"raca\": \"" + this.raca + "\",";
		json += "\"perfilComportamental\": \"" + this.perfilComportamental + "\",";
		json += "\"foto\": \"" + this.foto + "\",";
		json += "\"idDono\": " + this.idDono;
		json += "}";
		return json;
	}
}
