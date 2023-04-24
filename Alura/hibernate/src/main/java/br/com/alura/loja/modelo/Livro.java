package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Livro extends Produto{
    private String autor;
    private int numeroDePaginas;

    public Livro() {}

    public Livro(String nome, String descricao, BigDecimal preco, Categoria categoria, String autor, int numeroDePaginas) {
        super(nome, descricao, preco, categoria);
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }
}
