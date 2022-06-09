package br.com.senai.evelyngabrieli.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@RequestScoped //Só fica ativo quando é solicitado
public class IndexBean implements Serializable {

	 	public String getMensagem() {
	 		
	 		return "Texto vindo do Bean";
	 	}
}
