package br.com.senai.evelyngabrieli.application.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import br.com.senai.evelyngabrieli.model.Despesas;


@SuppressWarnings("serial")
@Named("tabela") //bean vai chamar tabela
@SessionScoped
public class TabelaBean implements Serializable {

	private List<Despesas> despesasList = new ArrayList<>(); // vai receber umaa lista chamada despesas e vai gravar tabela
	private ListDataModel<Despesas> despesas = new ListDataModel<>(despesasList); //usa para criar uma lista no jsf
	
	public String inserir() {
		Despesas d = new Despesas(); //cria um novo objeto
		d.setEdit(true);
		despesasList.add(d);
		return null;
	}
	
	public String excluir(Despesas despesa) {
		despesasList.remove(despesa); //removendo um objeto da lista
		return null;
	}
	
	public String editar(Despesas despesa) {
		despesa.setEdit(true); // se edit estiver true aparece o botao editar e excluir, mudar a forma que manipulo a tabela
		return null; 
		
	}
	
	public String gravar(Despesas despesa) { //se edit estiver falso vai aparecer o botao apenas de gravar
		despesa.setEdit(false);
		return null;
	}
	
	public ListDataModel<Despesas> getDespesas(){ //get vai capturar as despesas
		return despesas;
	}
	
	
	
}
