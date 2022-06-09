package br.com.rafaelcosta.jpa.ejbbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.jpa.model.Tarefa;

@Stateless// tipo de bean
public class TarefaBean {//Logica de negocio

	@PersistenceContext//vai ser responsavel por fazer a conexão com o banco de dados
	private EntityManager em;//classe da jpa que faz a conexão com o banco
	
	public void inserir(Tarefa tarefa) { // recebeu a tarefa
		em.persist(tarefa);// aqui inseri, grava
	}
	
	public void atualizar(Tarefa tarefa) {
		em.merge(tarefa);// merge faz um update, atualizar algo que ja existe
	}
	
	public void excluir(Tarefa tarefa) {
		tarefa = carregar(tarefa.getId());//passou o id no carregar, depois disso vai estar vinculado com o banco
		em.remove(tarefa);//remove o que esta la
	}
	
	public Tarefa carregar(int id) {
		return em.find(Tarefa.class, id);// recebe o id que quer carregar e procura na tabela
	}
}
