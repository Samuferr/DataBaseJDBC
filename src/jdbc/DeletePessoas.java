package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletePessoas {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe o código: ");
		int codigo = sc.nextInt();
		
		Connection conexao = FactoryConnection.getConnection();
		String deleteSql = "DELETE FROM pessoas WHERE codigo = ?";
		
		PreparedStatement stmt = conexao.prepareStatement(deleteSql);
		stmt.setInt(1, codigo);
		
		if(stmt.executeUpdate() > 0) {
			System.out.println("Pessoa excluida com Sucesso!!!");
		}else {
			System.out.println("Nada feito!");
		}
		
		conexao.close();
		sc.close();

	}

}
