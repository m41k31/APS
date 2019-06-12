package model;

public class Pacientes extends Pessoa {

	private int codigoPaciente;
	private String observacao;	

	public Pacientes(String nomePessoa, String dataNascimento, String email, String rg, String cpf, String sexo, String estadoCivil, String observacao) {
		super(nomePessoa, dataNascimento, email, rg, cpf, sexo, estadoCivil);
		this.observacao = observacao;
	}
	
	public int getCodigoPaciente() {
		return codigoPaciente;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

}