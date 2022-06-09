package br.com.senai.evelyngabrieli.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@RequestScoped //Dura somente quando é solicitado, tempo de vida da pagina

public class PageBean implements Serializable {
	
	private String page;
	
	public enum Pages{
		page_a, page_b; //enum 
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	
	public Pages goTo() //validação conforme o usuario sigitar a informação
		
		if("a".equals(page)) {
			return Pages.page_a;
			
		}else if("b".equals(page)) {
			return Pages.page_b;
		}else {
			return null;
		}

	}

}