package br.ufrn.imd.lp2.modelo;

public class Arma {
    
	private int danoMinimo;
    private int danoMaximo;
    private String nome;

    public Arma(String name, int min, int max) {
        nome = name;
        danoMinimo = min;
        danoMaximo = max;
    }

    public int getDanoMaximo() {
        return danoMaximo;
    }

    public int getDanoMinimo() {
        return danoMinimo;
    }

    public String getNome() {
        return nome;
    }


    public void setDanoMaximo(int danoMaximo) {
        this.danoMaximo = danoMaximo;
    }

    public void setDanoMinimo(int danoMinimo) {
        this.danoMinimo = danoMinimo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
