package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import model.Pessoa;

import connection.ConnectionFactory;

public class PessoaDAO {
	
	public void create(Pessoa o) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		try {
			preparedStmt = con.prepareStatement("INSERT INTO pessoa (nm_pessoa, dt_nascimento, de_email, nr_rg, nr_cpf, de_sexo, de_estadocivil) VALUES (?,?,?,?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, o.getNomePessoa());
			preparedStmt.setString(2, o.getDataNascimento());
			preparedStmt.setString(3, o.getEmail());
			preparedStmt.setString(4, o.getRg());
			preparedStmt.setString(5, o.getCpf());
			preparedStmt.setString(6, o.getSexo());
			preparedStmt.setString(7, o.getEstadoCivil());
			preparedStmt.executeUpdate();
			resultSet = preparedStmt.getGeneratedKeys();  
			resultSet.next();
			o.setCodigoPessoa(resultSet.getInt(1));
			resultSet.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt, resultSet);
		}
	}	
	
	public void delete(int id) {
		System.out.println(id);
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement("DELETE FROM pessoa WHERE cd_pessoa = ?;");
			preparedStmt.setInt(1, id);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt);
		}
	}

}