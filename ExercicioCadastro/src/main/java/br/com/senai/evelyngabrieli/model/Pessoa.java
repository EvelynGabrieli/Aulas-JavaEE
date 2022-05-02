package br.com.senai.evelyngabrieli.model;

import java.util.Date;

public class Pessoa {
	private String nome;
	private String email;
	private Date datanasc;
	private Endereco enderecoResidencial;
	private Telefone telefoneResidencial;
	private String nomeEmpresa;
	private Endereco enderecoComercial;
	private Telefone telefoneCelular;
	private Telefone telefoneComercial;
	private String cargo;
	private Double salario;
	private Integer[] interesses;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}
	public Endereco getEnderecoResidencial() {
		return enderecoResidencial;
	}
	public void setEnderecoResidencial(Endereco enderecoResidencial) {
		this.enderecoResidencial = enderecoResidencial;
	}
	public Telefone getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(Telefone telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public Endereco getEnderecoComercial() {
		return enderecoComercial;
	}
	public void setEnderecoComercial(Endereco enderecoComercial) {
		this.enderecoComercial = enderecoComercial;
	}
	public Telefone getTelefoneComercial() {
		return telefoneComercial;
	}
	public void setTelefoneComercial(Telefone telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Integer[] getInteresses() {
		return interesses;
	}
	public void setInteresses(Integer[] interesses) {
		this.interesses = interesses;
	}
	public Telefone getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(Telefone telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

}
