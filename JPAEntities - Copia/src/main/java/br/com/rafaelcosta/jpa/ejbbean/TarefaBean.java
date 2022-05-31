package br.com.rafaelcosta.jpa.ejbbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.jpa.model.Tarefa;

@Stateless// tipo de bean
public class TarefaBean {//Logica de negocio

	@PersistenceContext
	private EntityManager em;//classe da jpa que faz a conexão com o banco
	
	public void inserir(Tarefa tarefa) { // recebeu a tarefa
		em.persist(tarefa);// aqui inseri
	}
	
	public void atualizar(Tarefa tarefa) {
		em.merge(tarefa);// merge faz um update, atualizar algo que ja existe
	}
	
	public void excluir(Tarefa tarefa) {
		tarefa = carregar(tarefa.getId());
		em.remove(tarefa);//remove o que esta la
	}
	
	public Tarefa carregar(int id) {
		return em.find(Tarefa.class, id);// procura o id na tabela
	}
}
