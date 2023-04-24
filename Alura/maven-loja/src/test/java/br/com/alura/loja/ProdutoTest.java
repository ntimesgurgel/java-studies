package br.com.alura.loja;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;


public class ProdutoTest {

	@Test
	public void test() {
		Produto produto = new Produto("test",BigDecimal.TEN);
		Assert.assertEquals("teste", produto.getNome());
		Assert.assertEquals(BigDecimal.TEN, produto.getNome());
	}

}
