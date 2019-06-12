package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.Cargos;

public class CargosDAO {
	
	public ArrayList<String[]> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		
		ArrayList<String[]> listCargos = new ArrayList<>();
		try {
			preparedStmt = con.prepareStatement("SELECT cd_cargos, nm_cargo FROM cargos;");
			resultSet = preparedStmt.executeQuery();
			while(resultSet.next()) {
				String arrCargos[] = new String[2];
				arrCargos[0] = Integer.toString(resultSet.getInt("cd_cargos"));
				arrCargos[1] = resultSet.getString("nm_cargo"); 
				listCargos.add(arrCargos);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt, resultSet);
		}
		
		return listCargos;
		
	}	
	
	public void create(Cargos o) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement("INSERT INTO RelacionamentoCargosFuncionarios (cd_funcionario, cd_cargos) VALUES ((SELECT cd_funcionario FROM funcionarios WHERE cd_pessoa = ?), ?);");
			preparedStmt.setInt(1, o.getCodigoPessoa());
			preparedStmt.setInt(2, o.getCodigoCargo());
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
			preparedStmt = con.prepareStatement("INSERT INTO cargos (nm_cargo) VALUES (?);", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, nome);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt);
		}
	}
	
}
