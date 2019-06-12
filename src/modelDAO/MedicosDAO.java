package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.Medicos;

public class MedicosDAO {
	
	public void create(Medicos o) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement("INSERT INTO medicos (cd_crm, cd_funcionario) VALUES (?,?);");
			preparedStmt.setInt(1, o.getCrm());
			preparedStmt.setInt(2, o.getCodigoFuncionario());
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
		} finally {
			ConnectionFactory.closeConnection(con, preparedStmt);
		}
	}

}