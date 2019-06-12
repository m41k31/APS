package controller;

import java.util.ArrayList;

import model.Cargos;
import modelDAO.CargosDAO;

public class CargosControl {
	
	public static ArrayList<String[]>  listarCargos () {
		ArrayList<String[]> cargos = new ArrayList();
		CargosDAO cdao = new CargosDAO();
		cargos = cdao.read();
		return cargos;
	}
	
	public static void salvarCargo(int codigoCargo, int codigoPessoa) {
		Cargos cargo = new Cargos(codigoCargo, codigoPessoa);
		CargosDAO cdao = new CargosDAO();
		cdao.create(cargo);
	}
	
	//temporario
	public static void createBase(String nome) {
		CargosDAO cdao = new CargosDAO();
		cdao.create(nome);
	}

}