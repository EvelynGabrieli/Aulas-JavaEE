package br.com.rafaelcosta.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pagamento implements Serializable {
	public enum TipoPagamento {// enum pra padronizar pois quer que apareça os dois
		CARTAO_CREDITO,
		BOLETO
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	@Enumerated(EnumType.STRING) //pra escolher se quer o nome o id da escolha
	@Column(name = "tipo_pagto", length = 20, nullable = false) //qual o nome da coluna no banco, nome da coluna vai ser o mesmo nome do atributo
	private TipoPagamento tipoPagto;
	
	@OneToOne(mappedBy = "pagamento")//quem vai ser o responsavel pelo mapeamento
	private Pedido pedido;//relacionamento, 1 pedido pra um pagamento
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoPagamento getTipoPagto() {
		return tipoPagto;
	}

	public void setTipoPagto(TipoPagamento tipoPagto) {
		this.tipoPagto = tipoPagto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", tipoPagto=" + tipoPagto + "]";
	}
}
