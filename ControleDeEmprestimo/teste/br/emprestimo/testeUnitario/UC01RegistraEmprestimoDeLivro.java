package br.emprestimo.testeUnitario;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.dadosDeTeste.ObtemLivro;
import br.emprestimo.dadosDeTeste.ObtemUsuario;
import br.emprestimo.modelo.Emprestimo;
import br.emprestimo.modelo.Livro;
import br.emprestimo.modelo.Usuario;
import br.emprestimo.servico.ServicoEmprestimo;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class UC01RegistraEmprestimoDeLivro {
	static private Livro livro;
	static private Usuario usuario, usuarioInvalido;
	static private ServicoEmprestimo servico;
	static private Emprestimo emprestimo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//cenario
		livro = ObtemLivro.comDadosValidos();
		usuario = ObtemUsuario.comDadosValidos();
		usuarioInvalido = ObtemUsuario.comNomeBranco();
		servico = new ServicoEmprestimo();
		emprestimo = new Emprestimo();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test
	public void CT01UC01FB_registrar_emprestimo_com_sucesso() {
		assertNotNull(servico.empresta(livro, usuario));
	}
	@Test(expected=RuntimeException.class)
	public void CT02UC01FB_registrar_emprestimo_com_dados_invalidos() {
		assertNotNull(servico.empresta(null, usuario));
	}
	
	@Test(expected=RuntimeException.class)
	public void CT03UC01FB_registrar_emprestimo_com_dados_invalidos() {
		assertNotNull(servico.empresta(livro, null));
	}
	
	/*@Test
	public void CT03UC01FB_registrar_emprestimo_com_dados_invalidos(){
		try{
			servico.empresta(null, usuario);
			fail ("deveria lançar uma exceção");
		}catch(RuntimeException e){
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}*/
	@Test
	public void CT04UC01FB_registrar_emprestimo_com_sucesso_validacao_da_data() {
		//acao
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		emprestimo = servico.empresta(livro, usuario);
		String dataObtida = emprestimo.getDataDevolucao();
		//verificacao
	    assertTrue(dataEsperada.equals(dataObtida));
	}
	@Test
	public void CT05UC01FB_registrar_emprestimo_com_data_invalida() {
		assertFalse(emprestimo.validaData("30-03-2000"));
	}
	@Test(expected=RuntimeException.class)
	public void CT06UC01FB_registrar_emprestimo_com_livro_invalido_null() {
		emprestimo.setLivro(null);
	}
	@Test
	public void CT07UC01FB_verifica_estado_livro(){
		//Cenário
		Emprestimo umEmprestimo = new Emprestimo();
		//Ação
		umEmprestimo.setLivro(livro);
		//Validação
		assertTrue(umEmprestimo.getLivro().equals(livro));
	}

	@Test
	public void CT08UC01FB_verifica_estado_usuario(){
		//Cenário
		Emprestimo umEmprestimo = new Emprestimo();
		//Ação
		umEmprestimo.setUsuario(usuario);
		//Validação
		assertTrue(umEmprestimo.getUsuario().equals(usuario));
	}
	
	@Test
	public void CT09UC01FB_valida_data_valida(){
		emprestimo.setDataEmprestimo("17/12/2007");
	}
	
	@Test
	public void CT09UC01FB_valida_data_formato_invalido(){
		emprestimo.setDataEmprestimo("26-04-2018");
	}
	
	@Test
	public void CT10UC01FB_valida_data_invalida(){
		emprestimo.setDataEmprestimo("47/04/0002");
	}	

	@Test
	public void CT08UC01FB_verifica_estado_usuario_Invalido(){
		//Cenário
		Emprestimo umEmprestimo = new Emprestimo();
		//Ação
		umEmprestimo.setUsuario(null);
	}
}
