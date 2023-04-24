package jdbc.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionFactory;
import jdbc.dao.CategoriaDAO;
import jdbc.modelo.Categoria;
import jdbc.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection con = new ConnectionFactory().recuperarConexao()) {
			
			List<Categoria> listaDeCategorias = new CategoriaDAO(con).listWithProduct();
			
			listaDeCategorias.stream().forEach(c -> {
				System.out.println(c.getNome());

				for (Produto produto : c.getProdutos()) {
					System.out.println(c.getNome() + " - " + produto.getNome());
				}

			});
		}
	}
}
