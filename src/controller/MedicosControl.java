package controller;

import model.Funcionarios;
import model.Medicos;
import model.Pacientes;
import modelDAO.MedicosDAO;
import modelDAO.PacientesDAO;

public class MedicosControl {
	
	public static int salvarMedico(String nomePessoa, String dataNascimento, String email, String rg, String cpf, String sexo, String estadoCivil, int Crm, String login, String senha) {
		
		Medicos medico = new Medicos(nomePessoa, dataNascimento, email, rg, cpf, sexo, estadoCivil, Crm, login, senha);
		PessoaControl.salvarPessoa(medico);
		
		FuncionariosControl.salvarFuncionario(medico);
		
		MedicosDAO medicosDAO = new MedicosDAO();
		medicosDAO.create(medico);

		return medico.getCodigoPessoa();
		
	}

}