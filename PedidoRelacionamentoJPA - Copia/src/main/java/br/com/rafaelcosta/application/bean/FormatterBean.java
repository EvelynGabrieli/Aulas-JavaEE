package br.com.rafaelcosta.application.bean;
//formatar o valor

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped//vai ficar vivo durante toda a aplicação
public class FormatterBean implements Serializable {

	private static final Locale LOCALE_BR = new Locale("pt", "BR");// constante entrega a localização e a lingua
	
	public String formatarMoeda(double valor) {//
		NumberFormat nf = NumberFormat.getCurrencyInstance(LOCALE_BR);//classe do java que formata os numeros, pega a formatacao desse tipo de moeda e passa para nf
		return nf.format(valor);//formata esse valor, retorna o valor com R$
	}
}
