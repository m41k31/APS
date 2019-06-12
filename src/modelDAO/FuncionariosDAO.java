package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.Funcionarios;

public class FuncionariosDAO {

	public void create(Funcionarios o) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		try {
			preparedStmt = con.prepareStatement("INSERT INTO funcionarios (de_login, de_senha, cd_pessoa) VALUES (?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, o.getLogin());
			preparedStmt.setString(2, o.getSenha());
			preparedStmt.setInt(3, o.getCodigoPessoa());
			preparedStmt.executeUpdate();
			resultSet = preparedStmt.getGeneratedKeys();  
			resultSet.next();
			o.setCodigoFuncionario(resultSet.getInt(1));
			resultSet.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt, resultSet);
		}
	}
	
	public ArrayList<String[]> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		
		ArrayList<String[]> listPacientes = new ArrayList<>();
		try {
			preparedStmt = con.prepareStatement("SELECT funcionarios.cd_funcionario, nm_pessoa, dt_nascimento, nr_rg, nr_cpf, nm_cargo FROM funcionarios LEFT OUTER JOIN pessoa ON funcionarios.cd_pessoa = pessoa.cd_pessoa LEFT OUTER JOIN RelacionamentoCargosFuncionarios ON funcionarios.cd_funcionario = RelacionamentoCargosFuncionarios.cd_funcionario LEFT OUTER JOIN cargos ON cargos.cd_cargos = RelacionamentoCargosFuncionarios.cd_cargos;");
			resultSet = preparedStmt.executeQuery();
			while(resultSet.next()) {
				String arrPaciente[] = new String[6];
				arrPaciente[0] = Integer.toString(resultSet.getInt("cd_funcionario"));
				arrPaciente[1] = resultSet.getString("nm_pessoa"); 
				arrPaciente[2] = resultSet.getString("dt_nascimento"); 
				arrPaciente[3] = resultSet.getString("nr_rg");
				arrPaciente[4] = resultSet.getString("nr_cpf"); 
				arrPaciente[5] = resultSet.getString("nm_cargo"); 
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