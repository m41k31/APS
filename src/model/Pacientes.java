package model;

public class Pacientes extends Pessoa {

	public Pacientes(int codigoPessoa, String nomePessoa, String dataNascimento, String email, String rg, String cpf, String sexo, String estadoCivil, int codigoEndereco) {
		super(nomePessoa, dataNascimento, email, rg, cpf, sexo, estadoCivil, codigoEndereco, codigoPessoa);
	}

}
