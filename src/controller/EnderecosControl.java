package controller;

import java.util.ArrayList;

import model.Enderecos;
import model.Pessoa;
import modelDAO.EnderecosDAO;
import modelDAO.PessoaDAO;;

public class EnderecosControl {
	
	public static int salvarEndereco(String cep, String rua, String numero, String complemento, String bairro, String estado, String cidade) {
		Enderecos o = new Enderecos(cep, rua, numero, complemento, bairro, estado, cidade);
		EnderecosDAO dao = new EnderecosDAO();
		return dao.create(o);
	}
	
	public static ArrayList<String[]> resgatarPessoas() {
		ArrayList<String[]> enderecos = new ArrayList();
		EnderecosDAO pdao = new EnderecosDAO();
		
		for(Enderecos p: pdao.read()) {
			String arrPaciente[] = new String[1];
			arrPaciente[0] = p.getCidade(); 
			enderecos.add(arrPaciente);
		}
		/*ArrayList<String[]> pessoas = new ArrayList();
		ArrayList<Pessoa> P = Pessoa.getPessoas();
		
		for(int i = 0; i < P.size(); i++) {
			String p[] = new String[1];
			p[0] = P.get(i).getNomePessoa();
			pessoas.add(p);
		}*/
		
		return enderecos;		
	}
	
}
