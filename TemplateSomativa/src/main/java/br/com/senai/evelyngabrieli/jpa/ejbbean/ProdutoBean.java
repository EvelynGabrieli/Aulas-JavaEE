package br.com.senai.evelyngabrieli.jpa.ejbbean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.evelyngabrieli.application.model.Produtos;

@Stateless
public class ProdutoBean {

	@PersistenceContext 
	private EntityManager em;
	
	public List<Produtos> listar(){
		return em.createQuery("SELECT p FROM Produtos p", Produtos.class).getResultList();
	}
	
	
}
