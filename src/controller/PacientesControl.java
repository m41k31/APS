package controller;

import java.util.ArrayList;

import model.Pacientes;
import model.Pessoa;
import modelDAO.EnderecosDAO;
import modelDAO.PacientesDAO;
import modelDAO.PessoaDAO;

public class PacientesControl {
	
	public static void salvarPaciente(String nomePessoa, String dataNascimento, String email, String rg, String cpf, String sexo, String estadoCivil, int codigoEndereco) {
		Pessoa p = new Pessoa(nomePessoa, dataNascimento, email, rg, cpf, sexo, estadoCivil, codigoEndereco);
		PessoaDAO dao = new PessoaDAO();
		int codPessoa = dao.create(p);
		
		Pacientes paciente = new Pacientes(codPessoa, nomePessoa, dataNascimento, email, rg, cpf, sexo, estadoCivil, codigoEndereco);
		PacientesDAO pacienteDAO = new PacientesDAO();
		pacienteDAO.create(paciente);	
	}
	
	public static void updatePaciente(int id, String nomePessoa, String dataNascimento, String email, String rg, String cpf, String sexo, String estadoCivil, int codigoEndereco) {
		/*Pessoa p = new Pessoa(nomePessoa, dataNascimento, email, rg, cpf, sexo, estadoCivil, codigoEndereco);
		PessoaDAO dao = new PessoaDAO();
		int codPessoa = dao.create(p);
		
		Pacientes paciente = new Pacientes(codPessoa, nomePessoa, dataNascimento, email, rg, cpf, sexo, estadoCivil, codigoEndereco);
		PacientesDAO pacienteDAO = new PacientesDAO();
		pacienteDAO.create(paciente);*/
	}
	
	public static ArrayList<String[]> resgatarPacientes() {
		PacientesDAO pdao = new PacientesDAO();
		ArrayList<String[]> pacientes = pdao.read();
		return pacientes;		
	}
	
	public static void deletarPaciente(int id) {
		PacientesDAO pacientesDAO = new PacientesDAO();
		int codPessoa = pacientesDAO.delete(id);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		int codEndereco = pessoaDAO.delete(codPessoa);
		
		EnderecosDAO enderecosDAO = new EnderecosDAO();
		enderecosDAO.delete(codEndereco);
	}
	
	public static ArrayList<String[]> resgatarPacienteTotal(int id) {
		PacientesDAO pdao = new PacientesDAO();
		ArrayList<String[]> pacientes = pdao.readTotal(id);
		return pacientes;		
	}
	
}
