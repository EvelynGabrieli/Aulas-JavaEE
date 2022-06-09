package br.com.rafaelcosta.application.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.application.model.Cliente;


@Stateless//ejbs tem tempo de vida, parece com o request, toda vez que pede cria a transacao, terminou ele desconecta.
public class ClienteBean {

	@PersistenceContext
	private EntityManager em;
	
	public List<Cliente> listar() { //retorna uma lista
		return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();//criar uma query para fazere a pesquisa no banco de dados, faz a entidade se tranformar em uma tabela e por fim pega resultado dessa consulta
	}
}
