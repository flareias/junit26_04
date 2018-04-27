package br.emprestimo.dadosDeTeste;

import br.emprestimo.modelo.Usuario;

public class ObtemUsuario {

	public static Usuario comDadosValidos(){
	Usuario usuario = new Usuario();
	usuario.setRa("11111");
	usuario.setNome("Jose da Silva");
	return usuario;
	}
	public static Usuario comNomeBranco(){
	Usuario usuario = new Usuario();
	usuario.setRa("11111");
	usuario.setNome(" ");
	return usuario;
	}
}