package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.modelo.Livro;

public class UC06CadastrarLivro {
	public static Livro livro;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		livro = new Livro();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test(expected=RuntimeException.class)
	public void CT01UC06CadastrarLivro_com_isbn_invalido_branco() {
		livro.setIsbn("");
	}
	@Test(expected=RuntimeException.class)
	public void CT02UC06CadastrarLivro_com_isbn_invalido_nulo() {
		livro.setIsbn(null);
	}
	@Test
	public void CT03UC06CadastrarLivro_obtem_isbn_valido() {
		livro.setIsbn("121221");
		assertEquals("121221",livro.getIsbn());
	}
	


	
	@Test(expected=RuntimeException.class)
	public void CT04UC06CadastrarLivro_com_titulo_invalido_branco() {
		livro.setTitulo("");
	}
	@Test(expected=RuntimeException.class)
	public void CT05UC06CadastrarLivro_com_titulo_invalido_nulo() {
		livro.setTitulo(null);
	}
	@Test
	public void CT06UC06CadastrarLivro_obtem_titulo_valido() {
		livro.setTitulo("Engenharia de Software");
		assertEquals("Engenharia de Software",livro.getTitulo());
	}
	
	
	
	@Test(expected=RuntimeException.class)
	public void CT07UC06CadastrarLivro_com_autor_invalido_branco() {
		livro.setAutor("");
	}
	@Test(expected=RuntimeException.class)
	public void CT08UC06CadastrarLivro_com_autor_invalido_nulo() {
		livro.setAutor(null);
	}
	@Test
	public void CT09UC06CadastrarLivro_obtem_autor_valido() {
		livro.setAutor("Pressman");
		assertEquals("Pressman",livro.getAutor());
	}
}
