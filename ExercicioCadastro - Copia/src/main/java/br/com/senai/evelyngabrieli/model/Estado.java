package br.com.senai.evelyngabrieli.model;

public class Estado {
	
	private String sigla; //variaveis
	private String nome;

	public Estado() { //construtor vazio
		
	}
	
	public Estado(String sigla, String nome) {
		super();
		this.sigla = sigla;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	
}
	
	