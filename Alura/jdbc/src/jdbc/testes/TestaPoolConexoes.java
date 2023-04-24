package jdbc.testes;

import java.sql.SQLException;

import jdbc.ConnectionFactory;

public class TestaPoolConexoes {
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory conFactory = new ConnectionFactory();
		
		for (int i=0; i<20;i++) {
			conFactory.recuperarConexao();
			System.out.println("Conexão");
		}
	}
	
}
