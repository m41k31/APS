package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Pessoa;
import modelDAO.PessoaDAO;

public class PessoaControl {

	public static void salvarPessoa(Pessoa p) {
		PessoaDAO dao = new PessoaDAO();
		dao.create(p);
	}
	
}