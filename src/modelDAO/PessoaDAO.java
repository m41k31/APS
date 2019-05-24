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
	
	public int create(Pessoa p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		int codPessoa = 0;
		try {
			preparedStmt = con.prepareStatement("INSERT INTO pessoa (nm_pessoa, dt_nascimento, de_email, nr_rg, nr_cpf, de_sexo, de_estadocivil, cd_endereco) VALUES (?,?,?,?,?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, p.getNomePessoa());
			preparedStmt.setString(2, p.getDataNascimento());
			preparedStmt.setString(3, p.getEmail());
			preparedStmt.setString(4, p.getRg());
			preparedStmt.setString(5, p.getCpf());
			preparedStmt.setString(6, p.getSexo());
			preparedStmt.setString(7, p.getEstadoCivil());
			preparedStmt.setInt(8, p.getCodigoEndereco());
			preparedStmt.executeUpdate();
			resultSet = preparedStmt.getGeneratedKeys();  
			resultSet.next();
			codPessoa = resultSet.getInt(1);
			resultSet.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt);
		}
		return codPessoa;
	}
	
	public List<Pessoa> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		
		List<Pessoa> listPessoa = new ArrayList<>();
		try {
			preparedStmt = con.prepareStatement("SELECT * FROM pessoa;");
			resultSet = preparedStmt.executeQuery();
			while(resultSet.next()) {
				Pessoa p = new Pessoa(resultSet.getString("nm_pessoa"), resultSet.getString("dt_nascimento"), resultSet.getString("de_email"), resultSet.getString("nr_rg"), resultSet.getString("nr_cpf"), resultSet.getString("de_sexo"), resultSet.getString("de_estadocivil"), resultSet.getInt("cd_endereco"));
				listPessoa.add(p);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt, resultSet);
		}
		
		return listPessoa;
	}
	
	public int delete(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		int codEndereco = 0;
		try {
			preparedStmt = con.prepareStatement("DELETE FROM pessoa WHERE cd_pessoa = ?;", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setInt(1, id);
			preparedStmt.executeUpdate();
			resultSet = preparedStmt.getGeneratedKeys();  
			resultSet.next();
			codEndereco = resultSet.getInt(9);
			resultSet.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt);
		}
		return codEndereco;
	}

}
