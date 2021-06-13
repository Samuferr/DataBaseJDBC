package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePessoas {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe o codigo da pessoa: ");
		int cod = sc.nextInt();

		Connection conexao = FactoryConnection.getConnection();
		
		String select = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
		String update = "UPDATE pessoas SET nome = ? WHERE codigo = ?";

		
		PreparedStatement stmt = conexao.prepareStatement(select);
		stmt.setInt(1, cod);
		ResultSet resultado = stmt.executeQuery();
		
		if(resultado.next()) {
			Pessoa p = new Pessoa(resultado.getInt(1), resultado.getString(2));
			
			System.out.println("O nome atual é " + p.getNome());
			sc.nextLine();
			
			System.out.print("Informe o novo nome: ");
			String novoNome = sc.nextLine();
			
			stmt.close();
			stmt = conexao.prepareStatement(update);
			stmt.setString(1, novoNome);
			stmt.setInt(2, cod);
			stmt.execute();
			
			System.out.println("Pessoa alterada com sucesso!!!");
		}else {
			System.out.println("Pessoa não encontrada!");
		}
		
		
		stmt.close();
		conexao.close();
		sc.close();
		
		

	}

}
