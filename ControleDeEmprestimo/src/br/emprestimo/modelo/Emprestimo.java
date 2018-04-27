package br.emprestimo.modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Emprestimo {
	private Livro livro;
	private Usuario usuario;
	private String dataEmprestimo;
	private String dataDevolucao;

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		if (livro == null) {
			throw new RuntimeException("Livro invalido");
		}
		this.livro = livro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		if (usuario == null) {
			throw new RuntimeException("Usuário invalido");
		}
		this.usuario = usuario;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String data) {
		this.dataDevolucao = data;
	}

	/**
	 * * valida o formato da data * @param data no formato dd/MM/yyyy * @return true
	 * se a data estiver no formato valido e false para formato invalido
	 */
	public boolean validaData(String data) {
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		df.setLenient(false); //
		try {
			df.parse(data); // data válida
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}

}
