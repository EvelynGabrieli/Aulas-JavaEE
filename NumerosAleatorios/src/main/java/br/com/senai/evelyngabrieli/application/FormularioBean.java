package br.com.senai.evelyngabrieli.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@SuppressWarnings("serial")
@RequestScoped
@Named("formulario")
public class FormularioBean implements Serializable {
 
	private Integer number;
	private Integer minimo;
	private Integer maximo;
	
	private static Random random = new Random(); // classe que gera numeros aleatorios
	private List<Integer> numeros = new ArrayList<>(); //lista que armazena os numeros
	
	public String gerar() { //funcao para gerar os numeros de acordo com o que foi colocado
		for (int i = 0; i < number; i++) {
			int n = random.nextInt(maximo - minimo) + minimo + 1;
			numeros.add(n); //insere na variavel n
		}
		return null;
	}
	
	public List<Integer> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<Integer> numeros) {
		this.numeros = numeros;
	}

	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getMinimo() {
		return minimo;
	}
	public void setMinimo(Integer minimo) {
		this.minimo = minimo;
	}
	public Integer getMaximo() {
		return maximo;
	}
	public void setMaximo(Integer maximo) {
		this.maximo = maximo;
	}
	
}