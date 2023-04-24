package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Categoria;
import jdbc.modelo.Produto;

public class CategoriaDAO {

	private Connection con;
	
	public CategoriaDAO(Connection con) {
		this.con = con;
	}
	
	public List<Categoria> list() throws SQLException{
		List<Categoria> categorias = new ArrayList<>();
		
		String sql = "SELECT ID, NOME FROM CATEGORIA";
		
		try(PreparedStatement pstm = con.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()) {
				while(rst.next()) {
					Integer id = rst.getInt(1);
					String nome = rst.getString(2);
					
					Categoria categoria = new Categoria(id,nome);
					
					categorias.add(categoria);
				}
			}
		}
		return categorias;
		
	}

	public List<Categoria> listWithProduct() throws SQLException{
		Categoria ultima = null;
		List<Categoria> categorias = new ArrayList<>();
		
		String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN "
				+ "PRODUTO P ON C.ID = P.CATEGORIA_ID";
		
		try(PreparedStatement pstm = con.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()) {
				while(rst.next()) {

					String nome = rst.getString(2);
					if(ultima == null || !ultima.getNome().equals(nome)) {
						Integer id = rst.getInt(1);
						
						Categoria categoria = new Categoria(id,nome);
						ultima = categoria;

						categorias.add(categoria);
					}
					Produto produto = new Produto(rst.getInt(3),rst.getString(4),rst.getString(5));
					ultima.adicionar(produto);
				}
			}
		}
		return categorias;
	}
}
