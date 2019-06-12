package controller;

import java.util.ArrayList;

import model.Enderecos;
import model.Pacientes;
import model.Pessoa;
import modelDAO.EnderecosDAO;
import modelDAO.PacientesDAO;
import modelDAO.PessoaDAO;;

public class EnderecosControl {
	
	public static void salvarEndereco(String cep, String rua, String numero, String complemento, String bairro, String estado, String cidade, int codigoPessoa) {
		Enderecos endereco = new Enderecos(cep, rua, numero, complemento, bairro, estado, cidade, codigoPessoa);
		EnderecosDAO dao = new EnderecosDAO();
		dao.create(endereco);
	}
	
	public static ArrayList<String[]> resgatarPessoas() {
		ArrayList<String[]> enderecos = new ArrayList();
		EnderecosDAO pdao = new EnderecosDAO();
		
		for(Enderecos p: pdao.read()) {
			String arrPaciente[] = new String[1];
			arrPaciente[0] = p.getCidade(); 
			enderecos.add(arrPaciente);
		}
		
		return enderecos;		
	}
	
	public static void updateEndereco(String cep, String rua, String numero, String complemento, String bairro, String estado, String cidade, int codigoPessoa) {
		Enderecos endereco = new Enderecos(cep, rua, numero, complemento, bairro, estado, cidade, codigoPessoa);
		EnderecosDAO enderecoDAO = new EnderecosDAO();
		enderecoDAO.update(endereco);
	}
	
}