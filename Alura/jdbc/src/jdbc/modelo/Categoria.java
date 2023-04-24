package jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<>();
	
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "id: " + this.id + "| categoria: " + this.nome;
	}
	
	public String getNome() {
		return this.nome;
	}

	public int getId() {
		return this.id;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void adicionar(Produto produto) {
		produtos.add(produto);
	}
	
}
