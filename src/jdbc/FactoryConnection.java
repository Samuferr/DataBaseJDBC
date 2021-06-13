package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
	public static Connection getConnection(){
		try {
			final String url = "jdbc:mysql://localhost/curso_java";
			final String usuario = "root";
			final String senha = "12345678";
			
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
