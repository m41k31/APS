package model;

import java.util.ArrayList;

public class Pessoa {
	private String nomePessoa;
	private String dataNascimento;
	private String email;
	private String rg;
	private String cpf;
	private String sexo;
	private String estadoCivil;
	private int codigoEndereco;
	private int codigoPessoa;

	public Pessoa(String nomePessoa, String dataNascimento, String email, String rg, String cpf, String sexo, String estadoCivil, int codigoEndereco, int codigoPessoa) {
		this.nomePessoa = nomePessoa;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.codigoEndereco = codigoEndereco;	
		this.codigoPessoa = codigoPessoa;
	}
	
	public Pessoa(String nomePessoa, String dataNascimento, String email, String rg, String cpf, String sexo, String estadoCivil, int codigoEndereco) {
		this.nomePessoa = nomePessoa;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.codigoEndereco = codigoEndereco;	
		this.codigoPessoa = codigoPessoa;
	}
	
	public int getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}
	
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public int getCodigoEndereco() {
		return codigoEndereco;
	}
	
	public void setCodigoEndereco(int codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}	
	
}
