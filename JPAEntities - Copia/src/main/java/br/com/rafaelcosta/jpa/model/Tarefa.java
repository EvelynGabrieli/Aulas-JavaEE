package br.com.rafaelcosta.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity//diz que é uma entidade que vai guardar no banco de dados, quando o java le ele cria a tabela
public class Tarefa { //objeto tarefa

	@Id //id vai ser um pk
	@GeneratedValue // vai gerar automatico
	private Integer id; //atributo id
	
	private String descricao;
	
	private Integer prioridade;
	
	private Boolean concluida;

	public Integer getId() { //metodo get
		return id;
	}

	public void setId(Integer id) {//metodo set
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}	
	
	
	
}
