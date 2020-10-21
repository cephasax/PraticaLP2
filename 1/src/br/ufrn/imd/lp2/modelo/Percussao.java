package br.ufrn.imd.lp2.modelo;

public class Percussao extends Instrumento{

    public Percussao(String nome) {
        super(nome);
    }

    public void tocarApresentacaoMusical() {
        System.out.println("Tocando apresentacao musical do instrumento: " + this.nome);
    }
}
