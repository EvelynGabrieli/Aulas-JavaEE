package br.com.senai.evelyngabrieli.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@RequestScoped //tempo de vida da pagina
public class IndexBean implements Serializable {

	 	public String getMensagem() { //Metodo que mostra a mensagem.
	 		
	 		return "Texto vindo do Bean";
	 	}
}
