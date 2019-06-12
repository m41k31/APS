package controller;

import java.util.ArrayList;

import model.Funcionarios;
import modelDAO.FuncionariosDAO;

public class FuncionariosControl {

	public static void salvarFuncionario(Funcionarios f) {
		FuncionariosDAO dao = new FuncionariosDAO();
		dao.create(f);
	}
	
	public static int salvarFuncionario(String nomePessoa, String dataNascimento, String email, String rg, String cpf, String sexo, String estadoCivil, String login, String senha) {
		Funcionarios funcionario = new Funcionarios(login, senha, nomePessoa, dataNascimento, email, rg, cpf, sexo, estadoCivil);
		PessoaControl.salvarPessoa(funcionario);
		
		FuncionariosDAO dao = new FuncionariosDAO();
		dao.create(funcionario);
		
		return funcionario.getCodigoPessoa();
	}
	
	public static ArrayList<String[]> listarFuncionarios() {
		FuncionariosDAO pdao = new FuncionariosDAO();
		ArrayList<String[]> funcionarios = pdao.read();
		return funcionarios;		
	}	
	
}