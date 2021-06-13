package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertPessoa {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe Nome: ");
		String nome = sc.nextLine();
		
		Connection conexao = FactoryConnection.getConnection();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		
		stmt.execute();
		
		System.out.println("Pessoa criada com Sucesso!!!");
		

		sc.close();


	}

}
