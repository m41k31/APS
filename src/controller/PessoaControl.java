package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Pessoa;
import modelDAO.PessoaDAO;

public class PessoaControl {

	public static int salvarPessoa(String nomePessoa, String dataNascimento, String email, String rg, String cpf, String sexo, String estadoCivil, int codigoEndereco) {
		Pessoa p = new Pessoa(nomePessoa, dataNascimento, email, rg, cpf, sexo, estadoCivil, codigoEndereco);
		PessoaDAO dao = new PessoaDAO();
		return dao.create(p);	
	}
	
	public static ArrayList<String[]> resgatarPessoas() {
		ArrayList<String[]> pessoas = new ArrayList();
		PessoaDAO pdao = new PessoaDAO();
		
		for(Pessoa p: pdao.read()) {
			String arrPaciente[] = new String[1];
			arrPaciente[0] = p.getNomePessoa(); 
			pessoas.add(arrPaciente);
		}
		/*ArrayList<String[]> pessoas = new ArrayList();
		ArrayList<Pessoa> P = Pessoa.getPessoas();
		
		for(int i = 0; i < P.size(); i++) {
			String p[] = new String[1];
			p[0] = P.get(i).getNomePessoa();
			pessoas.add(p);
		}*/
		
		return pessoas;		
	}
	
}
