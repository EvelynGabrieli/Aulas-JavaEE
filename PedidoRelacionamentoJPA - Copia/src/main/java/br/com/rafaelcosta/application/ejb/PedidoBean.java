package br.com.rafaelcosta.application.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.application.model.Cliente;
import br.com.rafaelcosta.application.model.Pagamento;
import br.com.rafaelcosta.application.model.Pagamento.TipoPagamento;
import br.com.rafaelcosta.application.model.Pedido;
import br.com.rafaelcosta.application.model.Produto;


@Stateless
public class PedidoBean {

	@PersistenceContext
	private EntityManager em;
	
	public List<Pedido> listar() { //vai listar todos os pedidos
		return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
	}
	
	public void pagar(Integer pedidoId, String tipo) { // recebe o id e o tipo de pagamento, cria uma variavel e transforma em enum
		TipoPagamento tipoPagamento = TipoPagamento.valueOf(tipo);
		Pedido pedido = em.find(Pedido.class, pedidoId);//criando um pedido e buscando ele na tabela pelo id
		
		Pagamento pagamento = new Pagamento();//variavel para pagamento
		pagamento.setTipoPagto(tipoPagamento); //seta o tipo de pagamento
		em.persist(pagamento);//salvei na tabela pagamento
		
		pedido.setPagamento(pagamento);//grava no banco de dados
	}
	
	public void excluir(Integer pedidoId) {
		Pedido pedido = em.find(Pedido.class, pedidoId);
		em.remove(pedido);
	}
	
	public void cadastrar(Integer clienteId, Integer[] produtosIds) throws Exception {
		Cliente cliente = em.find(Cliente.class, clienteId);
		
		Pedido pedido = new Pedido();
		pedido.setData(new Date());
		pedido.setCliente(cliente);
		em.persist(pedido);
		
		double valorTotal = 0;
		for (Integer produtoId : produtosIds) {
			Produto produto = em.find(Produto.class, produtoId);
			pedido.getProdutos().add(produto);
			valorTotal += produto.getValor();
		}
		
		pedido.setValorTotal(valorTotal);
	}
}

