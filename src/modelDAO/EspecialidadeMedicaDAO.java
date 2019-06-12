package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.Cargos;
import model.Enderecos;
import model.EspecialidadeMedica;


public class EspecialidadeMedicaDAO {
	
	public ArrayList<String[]> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		
		ArrayList<String[]> listEspecialidadeMedica = new ArrayList<>();
		try {
			preparedStmt = con.prepareStatement("SELECT cd_especialidademedica, de_especialidade FROM EspecialidadeMedica;");
			resultSet = preparedStmt.executeQuery();
			while(resultSet.next()) {
				String arrEspecialidadeMedica[] = new String[2];
				arrEspecialidadeMedica[0] = Integer.toString(resultSet.getInt("cd_especialidademedica"));
				arrEspecialidadeMedica[1] = resultSet.getString("de_especialidade"); 
				listEspecialidadeMedica.add(arrEspecialidadeMedica);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt, resultSet);
		}
		
		return listEspecialidadeMedica;		
	}	
	
	public void create(EspecialidadeMedica o) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement("INSERT INTO RelacionamentoEspecialidadeMedicaMedicos (cd_especialidademedica, cd_crm) VALUES (?, (SELECT cd_crm FROM medicos WHERE cd_funcionario = (SELECT cd_funcionario FROM funcionarios WHERE cd_pessoa = ?)));	");
			preparedStmt.setInt(1, o.getCodigoespMedica());
			preparedStmt.setInt(2, o.getCodigoPessoa());
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt);
		}
	}
	
	//temporario
	public void create(String nome) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement("INSERT INTO EspecialidadeMedica (de_especialidade) VALUES (?);", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, nome);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt);
		}
	}
	
	
}