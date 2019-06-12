package controller;

import java.util.ArrayList;

import model.Cargos;
import model.EspecialidadeMedica;
import modelDAO.CargosDAO;
import modelDAO.EspecialidadeMedicaDAO;

public class  EspecialidadeMedicaControl {
	
	public static ArrayList<String[]>  listarEspecialidades () {
		ArrayList<String[]> especialidades = new ArrayList();
		EspecialidadeMedicaDAO cdao = new EspecialidadeMedicaDAO();
		especialidades = cdao.read();
		return especialidades;
	}
	
	public static void salvarEspecialidade(int codigoEspecialidadeMedica, int codigoPessoa) {
		EspecialidadeMedica especialidade = new EspecialidadeMedica(codigoEspecialidadeMedica, codigoPessoa);
		EspecialidadeMedicaDAO cdao = new EspecialidadeMedicaDAO();
		cdao.create(especialidade);
	}
	
	//temporario
	public static void createBase(String nome) {
		EspecialidadeMedicaDAO cdao = new EspecialidadeMedicaDAO();
		cdao.create(nome);
	}
	
}
