package br.ufrn.imd.lp2.modelo;

import br.ufrn.imd.lp2.excecoes.TipoInvalidoMelodicoException;

public class Melodico extends Instrumento{
	
	private String notaMaisAguda;
	private String notaMaisGrave;
	private String tipo;

	public Melodico(String nome, String notaMaisAguda, String notaMaisGrave, String tipo)
			throws TipoInvalidoMelodicoException {
		
		super(nome);
		this.notaMaisAguda = notaMaisAguda;
		this.notaMaisGrave = notaMaisGrave;
		this.tipo = new String(tipo);
		
		if (tipo.equals("cordas") && tipo.equals("metais") && tipo.equals("palhetas")) {
			throw new TipoInvalidoMelodicoException(
					"Um instrumento melodico deve ser do tipo cordas ou metais ou palhetas!");
		}
	}

	public void tocarApresentacaoMusical() {
		System.out.println("Tocando apresentacao musical do instrumento: " + this.nome);
	}

	public String getNotaMaisAguda() {
		return notaMaisAguda;
	}

	public void setNotaMaisAguda(String notaMaisAguda) {
		this.notaMaisAguda = notaMaisAguda;
	}

	public String getNotaMaisGrave() {
		return notaMaisGrave;
	}

	public void setNotaMaisGrave(String notaMaisGrave) {
		this.notaMaisGrave = notaMaisGrave;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
