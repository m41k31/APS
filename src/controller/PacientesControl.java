package controller;

import java.util.ArrayList;

import model.Pacientes;
import model.Pessoa;
import modelDAO.EnderecosDAO;
import modelDAO.PacientesDAO;
import modelDAO.PessoaDAO;

public class PacientesControl {
	
	public static int salvarPaciente(String nomePessoa, String dataNascimento, String email, String rg, String cpf, String sexo, String estadoCivil, String observacao) {	
		Pacientes paciente = new Pacientes(nomePessoa, dataNascimento, email, rg, cpf, sexo, estadoCivil, observacao);		
		PessoaControl.salvarPessoa(paciente);		

		PacientesDAO pacienteDAO = new PacientesDAO();
		pacienteDAO.create(paciente);
		
		return paciente.getCodigoPessoa();
	}
	
	public static int updatePaciente(String nomePessoa, String dataNascimento, String email, String rg, String cpf, String sexo, String estadoCivil, String observacao, int codigoPaciente) {
		Pacientes paciente = new Pacientes(nomePessoa, dataNascimento, email, rg, cpf, sexo, estadoCivil, observacao);
		paciente.setCodigoPaciente(codigoPaciente);
		PacientesDAO pacienteDAO = new PacientesDAO();
		return pacienteDAO.update(paciente);
	}
	
	public static ArrayList<String[]> listarPacientes() {
		PacientesDAO pdao = new PacientesDAO();
		ArrayList<String[]> pacientes = pdao.read();
		return pacientes;		
	}
	
	public static void deletarPaciente(int id) {
		PacientesDAO pacientesDAO = new PacientesDAO();
		int codigoPessoa = pacientesDAO.delete(id);

		EnderecosDAO enderecosDAO = new EnderecosDAO();
		enderecosDAO.delete(codigoPessoa);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.delete(codigoPessoa);
	}
	
	public static ArrayList<String[]> resgatarPacienteTotal(int id) {
		PacientesDAO pdao = new PacientesDAO();
		ArrayList<String[]> pacientes = pdao.readTotal(id);
		return pacientes;
	}
	
	public static ArrayList<String[]> pesquisarPaciente(String nome) {
		PacientesDAO pdao = new PacientesDAO();
		ArrayList<String[]> pacientes = pdao.search(nome);
		return pacientes;		
	}
	
}