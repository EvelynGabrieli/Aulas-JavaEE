package br.com.senai.evelyngabrieli.application;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped // tempo de vida
public class PageBean implements Serializable{
	private String nome;

	@Inject
	private Flash flash;
	
	public String processar() { //metodo processar que valida o nome
		
		flash.put("nomeDoUsuario", nome); // flash envia e passa para a outra pagina
		
		return "result?faces-redirect=true";
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
}
