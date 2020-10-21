package br.ufrn.imd.lp2.modelo;

public class GrupoMusical implements ApresentacaoMusical {

	private String nome;

	public GrupoMusical(String nome) {
		this.nome = new String(nome);
	}

	public void tocarApresentacaoMusical(){
		System.out.println("Tocando apresentacao musical do grupo musical: " + this.nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
