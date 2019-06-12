package model;

public class Medicos extends Funcionarios {

	private int crm;	

	public Medicos(String nomePessoa, String dataNascimento, String email, String rg, String cpf, String sexo, String estadoCivil, int crm, String login, String senha) {
		super(login, senha, nomePessoa, dataNascimento, email, rg, cpf, sexo, estadoCivil);
		this.crm = crm;
	}
	
	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}
	
}