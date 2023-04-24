package jdbc.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory conFactory = new ConnectionFactory();
		try (Connection con = conFactory.recuperarConexao()) {
			con.setAutoCommit(false);

			try (PreparedStatement stm = con.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) " + "VALUES ('?','?')", Statement.RETURN_GENERATED_KEYS);) {

				adicionarVariavel("SmartTV", "42Polegadas", stm);
				adicionarVariavel("PC Gamer", "core i7", stm);

				con.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				con.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id do produto criado foi " + id);
			}
		}
	}
}
