package jdbc.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionFactory;
import jdbc.dao.ProductDAO;
import jdbc.modelo.Produto;

public class TestaInsercaoComProduto {
	
	public static void main(String[] args) throws SQLException {
	
		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");
		
		try(Connection con = new ConnectionFactory().recuperarConexao()) {
			ProductDAO productDAO = new ProductDAO(con);
			productDAO.salvarProduto(comoda);
			List<Produto> listaDeProdutos = productDAO.list();
			listaDeProdutos.stream().forEach(lp->System.out.println(lp));
		}
	}
}
