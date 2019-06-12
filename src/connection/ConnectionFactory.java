package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
	
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/aps";
	private static final String USER = "aps";
	private static final String PASSWORD = "aps";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro na conexão: ", e);
		}
	}
	
	public static void closeConnection(Connection con) {
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement preparedStmt) {		
		closeConnection(con);
		
		try {
			if(preparedStmt != null) {
				preparedStmt.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement preparedStmt, ResultSet resultSet) {		
		closeConnection(con, preparedStmt);
		
		try {
			if(resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			
		}
	}
}