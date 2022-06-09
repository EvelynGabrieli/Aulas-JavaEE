package br.com.rafaelcosta.jpa.jsfbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rafaelcosta.jpa.ejbbean.TarefaBean;
import br.com.rafaelcosta.jpa.model.Tarefa;

@Named("form")
@RequestScoped //tempo de vida é de requisição, quando termina a requisição apaga o objeto
public class FormBean implements Serializable {
	
	@EJB
	private TarefaBean tarefaBean;//criando uma variavel 

	@Inject
	private FacesContext context;// injetam codigo por tras sem preisar mexer, ejb
	
	private UIComponent searchInputText;
	
	private Integer tarefaId;//atributo simples
	
	private Tarefa tarefa;//objeto
	
	public void gravar(AjaxBehaviorEvent event) { //metodo gravar,recebe um evento de ajax, 
		if(tarefa.getId()==null) { // pegando o id e ver se existe
			tarefaBean.inserir(tarefa);// se nao existir inserir tarefa
		}else {
			tarefaBean.atualizar(tarefa); // se existir, atualiza tarefa
		}		
	}
	
	public void pesquisar(AjaxBehaviorEvent event) {// recebe o evento do ajax
		tarefa = tarefaBean.carregar(tarefaId);//aqui passou o evento da tarefa que no caso é o id.
		
		if(tarefa == null) {// se não existe a tarefa
			context.addMessage(searchInputText.getClientId(context),//pega o context e adiciona uma mensagem, no input text da pequisa pega o id da pesquisa e passa o context, context pega as informações que acontecem no formulario(se deu erro, clicou no botao e etc)
					new FacesMessage("Tarefa n�o encontrada"));//
		}
		tarefaId = null;//retorna pra mesma pagina		
	}
	
	public void excluir(AjaxBehaviorEvent event) {
		tarefaBean.excluir(tarefa);//vai chamar o tarefabean e vai excluir a tarefa que esta na tela
		tarefa = null;//tela vai voltar limpa
	}
	public Tarefa getTarefa() {//procura a tafera
		if(tarefa==null) {//se a tarefa ainda não existir eu dou um new cria uma nova
			tarefa = new Tarefa();
		}
		return tarefa;// se a tarefa existir pega ela e faz um #{}
	}

	public UIComponent getSearchInputText() { 
		return searchInputText;
	}

	public void setSearchInputText(UIComponent searchInputText) {
		this.searchInputText = searchInputText;
	}

	public Integer getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(Integer tarefaId) {
		this.tarefaId = tarefaId;
	}
	
	
	
}
