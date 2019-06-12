package model;

public class Funcionarios extends Pessoa {
	
	private String login, senha;
	private int codigoFuncionario;
	
	public Funcionarios(String login, String senha, String nomePessoa, String dataNascimento, String email, String rg, String cpf, String sexo, String estadoCivil) {
		super(nomePessoa, dataNascimento, email, rg, cpf, sexo, estadoCivil);
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(int codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	
}