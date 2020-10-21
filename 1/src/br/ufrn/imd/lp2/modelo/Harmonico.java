package br.ufrn.imd.lp2.modelo;

public class Harmonico extends Instrumento{

    private String notaMaisAguda;
    private String notaMaisGrave;

    public Harmonico(String nome, String notaMaisAguda, String notaMaisGrave) {
        super(nome);
        this.notaMaisAguda = new String(notaMaisAguda);
        this.notaMaisGrave = new String(notaMaisGrave);
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
    
}
