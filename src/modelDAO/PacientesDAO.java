package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.Enderecos;
import model.Pacientes;

public class PacientesDAO {
	
	public void create(Pacientes o) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement("INSERT INTO pacientes (cd_pessoa) VALUES (?);");
			preparedStmt.setInt(1, o.getCodigoPessoa());
			preparedStmt.executeUpdate();
			preparedStmt.getGeneratedKeys();  
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt);
		}
	}
	
	public ArrayList<String[]> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		
		ArrayList<String[]> listPacientes = new ArrayList<>();
		try {
			preparedStmt = con.prepareStatement("SELECT cd_paciente, nm_pessoa, dt_nascimento, nr_rg, nr_cpf FROM pacientes JOIN pessoa on pacientes.cd_pessoa = pessoa.cd_pessoa;");
			resultSet = preparedStmt.executeQuery();
			while(resultSet.next()) {
				String arrPaciente[] = new String[5];
				arrPaciente[0] = Integer.toString(resultSet.getInt("cd_paciente"));
				arrPaciente[1] = resultSet.getString("nm_pessoa"); 
				arrPaciente[2] = resultSet.getString("dt_nascimento"); 
				arrPaciente[3] = resultSet.getString("nr_rg");
				arrPaciente[4] = resultSet.getString("nr_cpf"); 
				//Pacientes o = new Pacientes(resultSet.getInt("cd_paciente"));
				listPacientes.add(arrPaciente);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt, resultSet);
		}
		
		return listPacientes;
	}
	
	public int delete(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		int codPessoa = 0;
		try {
			preparedStmt = con.prepareStatement("DELETE FROM pacientes WHERE cd_paciente = ?;", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setInt(1, id);
			preparedStmt.executeUpdate();
			resultSet = preparedStmt.getGeneratedKeys();  
			resultSet.next();
			codPessoa = resultSet.getInt(2);
			resultSet.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt, resultSet);
		}
		return codPessoa;
	}
	
	public ArrayList<String[]> readTotal(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		
		ArrayList<String[]> listPacientes = new ArrayList<>();
		try {
			//SELECT cd_paciente, nm_pessoa, dt_nascimento, de_email, nr_rg, nr_cpf, de_sexo, de_estadocivil, cd_endereco FROM pacientes JOIN pessoa on pacientes.cd_pessoa = pessoa.cd_pessoa;
			preparedStmt = con.prepareStatement("SELECT cd_paciente, nm_pessoa, dt_nascimento, de_email, nr_rg, nr_cpf, de_sexo, de_estadocivil, nr_cep, de_logradouro, nr_numero, de_complemento, de_bairro, de_estado, de_cidade FROM pacientes JOIN pessoa on pacientes.cd_pessoa = pessoa.cd_pessoa JOIN enderecos on pessoa.cd_endereco = enderecos.cd_endereco WHERE cd_paciente = ?;");
			preparedStmt.setInt(1, id);
			resultSet = preparedStmt.executeQuery();
			while(resultSet.next()) {
				String arrPaciente[] = new String[15];
				arrPaciente[0] = Integer.toString(resultSet.getInt("cd_paciente"));
				arrPaciente[1] = resultSet.getString("nm_pessoa"); 
				arrPaciente[2] = resultSet.getString("dt_nascimento"); 
				arrPaciente[3] = resultSet.getString("de_email"); 
				arrPaciente[4] = resultSet.getString("nr_rg");
				arrPaciente[5] = resultSet.getString("nr_cpf"); 
				arrPaciente[6] = resultSet.getString("de_sexo"); 
				arrPaciente[7] = resultSet.getString("de_estadocivil"); 
				arrPaciente[8] = resultSet.getString("de_logradouro"); 
				arrPaciente[9] = resultSet.getString("nr_cep");
				arrPaciente[10] = resultSet.getString("nr_numero"); 
				arrPaciente[11] = resultSet.getString("de_complemento"); 
				arrPaciente[12] = resultSet.getString("de_bairro"); 
				arrPaciente[13] = resultSet.getString("de_estado"); 
				arrPaciente[14] = resultSet.getString("de_cidade"); 
				//Pacientes o = new Pacientes(resultSet.getInt("cd_paciente"));
				listPacientes.add(arrPaciente);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt, resultSet);
		}
		
		return listPacientes;
	}
	
}
