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
import model.Pessoa;;

public class EnderecosDAO {
	
	public int create(Enderecos o) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		int codEndereco = 0;
		try {
			preparedStmt = con.prepareStatement("INSERT INTO enderecos (nr_cep, de_logradouro, nr_numero, de_complemento, de_bairro, de_estado, de_cidade) VALUES (?,?,?,?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, o.getCep());
			preparedStmt.setString(2, o.getRua());
			preparedStmt.setString(3, o.getNumero());
			preparedStmt.setString(4, o.getComplemento());
			preparedStmt.setString(5, o.getBairro());
			preparedStmt.setString(6, o.getEstado());
			preparedStmt.setString(7, o.getCidade());
			preparedStmt.executeUpdate();
			resultSet = preparedStmt.getGeneratedKeys();
			resultSet.next();
			codEndereco = resultSet.getInt(1);
			resultSet.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt, resultSet);
		}
		return codEndereco;
	}
	
	public List<Enderecos> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		
		List<Enderecos> listEnderecos = new ArrayList<>();
		try {
			preparedStmt = con.prepareStatement("SELECT * FROM enderecos;");
			resultSet = preparedStmt.executeQuery();
			while(resultSet.next()) {
				Enderecos o = new Enderecos(resultSet.getString("nr_cep"), resultSet.getString("de_logradouro"), resultSet.getString("nr_numero"), resultSet.getString("de_complemento"), resultSet.getString("de_bairro"), resultSet.getString("de_estado"), resultSet.getString("de_cidade"));
				listEnderecos.add(o);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt, resultSet);
		}
		
		return listEnderecos;
	}
	
	public void delete(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement("DELETE FROM enderecos WHERE cd_endereco = ?;");
			preparedStmt.setInt(1, id);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt);
		}
	}
	
}