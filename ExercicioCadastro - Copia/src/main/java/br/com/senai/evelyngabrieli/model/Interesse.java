package br.com.senai.evelyngabrieli.model;

public class Interesse {

	private Integer id;
	private String area;
	
	
	public Interesse(Integer id, String area) { //parametros
		super();
		this.id = id;
		this.area = area;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	
}
