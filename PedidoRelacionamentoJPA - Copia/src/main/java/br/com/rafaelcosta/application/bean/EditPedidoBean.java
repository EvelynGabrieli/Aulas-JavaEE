package br.com.rafaelcosta.application.bean;
//vai editar
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafaelcosta.application.ejb.ClienteBean;
import br.com.rafaelcosta.application.ejb.PedidoBean;
import br.com.rafaelcosta.application.ejb.ProdutoBean;
import br.com.rafaelcosta.application.model.Cliente;
import br.com.rafaelcosta.application.model.Produto;


@Named
@RequestScoped
public class EditPedidoBean implements Serializable {
	
	@EJB// quem vai mexer no banco
	private PedidoBean pedidoBean;// vai gravar um pedido
	
	@EJB
	private ProdutoBean produtoBean;//vai gravar um produto
	
	@EJB
	private ClienteBean clienteBean;// vai gravar o cliente
	
	private List<Cliente> clientes;//vai listar todos os clientes
	private List<Produto> produtos;// vai listar todos os produto
	
	private Integer selectedClienteId;// qual o id do cliente
	private Integer[] selectedProdutosIds;//aonde carrega os produtos na tela
	
	@PostConstruct //assim que carregou a pagina executa esse metodo
	public void init() {
		//mostra na tela todos os clientes e produtos cadastrados assim que iniciar
		clientes = clienteBean.listar();
		produtos = produtoBean.listar();
	}
	
	public String cadastrarPedido() throws Exception { //pega o pedido bean e lança o cadastrar
		pedidoBean.cadastrar(selectedClienteId, selectedProdutosIds);	// pega o id do cliente e o id do produto
		return "pedidos?faces-redirect=true";// apaga o que esta na tela, forca a ser um novo request
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Integer getSelectedClienteId() {
		return selectedClienteId;
	}

	public void setSelectedClienteId(Integer selectedClienteId) {
		this.selectedClienteId = selectedClienteId;
	}

	public Integer[] getSelectedProdutosIds() { // preencher o select cliente
		return selectedProdutosIds;
	}

	public void setSelectedProdutosIds(Integer[] selectedProdutosIds) {// entrega
		this.selectedProdutosIds = selectedProdutosIds;
	}
}