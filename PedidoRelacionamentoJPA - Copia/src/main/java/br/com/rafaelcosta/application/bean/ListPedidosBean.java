package br.com.rafaelcosta.application.bean;
//lista todos os pedidos, 2 tela que vai a tabela
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafaelcosta.application.ejb.PedidoBean;
import br.com.rafaelcosta.application.model.Pedido;


@Named
@RequestScoped
public class ListPedidosBean implements Serializable {

	@EJB
	private PedidoBean pedidoBean;
	
	private List<Pedido> pedidos; //lista de pedidos
	
	@PostConstruct//vai carregar a lista de pedidos
	public void init() {
		pedidos = pedidoBean.listar();
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public String pagar(Integer pedidoId, String tipo) throws Exception  {//pagar vai receber o numero e o tipo de pedido e vai repassar para o bean
		pedidoBean.pagar(pedidoId, tipo);
		return "pedidos?faces-redirect=true";//apaga as informaçoes antigas e atualiza com as informações novas
	}
	
	public String excluir(Integer pedidoId) {
		pedidoBean.excluir(pedidoId);
		return "pedidos?faces-redirect=true";
	}
}
