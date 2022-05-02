package br.com.senai.evelyngabrieli.application;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.senai.evelyngabrieli.model.Endereco;
import br.com.senai.evelyngabrieli.model.Estado;
import br.com.senai.evelyngabrieli.model.Interesse;
import br.com.senai.evelyngabrieli.model.Pessoa;
import br.com.senai.evelyngabrieli.model.Telefone;
import br.com.senai.evelyngabrieli.util.InicializacaoConstantes;
@SuppressWarnings("serial")
@RequestScoped
@Named("cadastro")
public class CadastroBean implements Serializable {

	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		if (pessoa ==  null) {
			pessoa = new Pessoa();
			pessoa.setEnderecoResidencial(new Endereco());
			pessoa.getEnderecoResidencial().setEstado(new Estado());
			pessoa.setEnderecoComercial(new Endereco());
			pessoa.getEnderecoComercial().setEstado(new Estado());
			pessoa.setTelefoneResidencial(new Telefone());
			pessoa.setTelefoneCelular(new Telefone());
			pessoa.setTelefoneComercial(new Telefone());
		
		}
		return pessoa;
		
	}
	
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Estado> getEstados(){
		return InicializacaoConstantes.ESTADOS;
	}
	
	public List<Interesse> getInteresses(){
		return  InicializacaoConstantes.INTERESSES;
	}
}
