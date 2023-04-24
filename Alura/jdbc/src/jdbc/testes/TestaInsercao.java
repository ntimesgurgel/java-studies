package jdbc.testes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.ConnectionFactory;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory conFactory = new ConnectionFactory();
		Connection con = conFactory.recuperarConexao();
		
		Statement stm = con.createStatement();
		stm.execute("INSERT INTO PRODUTO (nome, descricao) "
				+ "VALUES ('MOUSE','BLUETOOTH')", 
				Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id do produto criado foi " + id);
		}
		
		con.close();
	}
}
