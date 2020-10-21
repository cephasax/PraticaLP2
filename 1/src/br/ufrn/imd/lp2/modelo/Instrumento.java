package br.ufrn.imd.lp2.modelo;

import java.util.ArrayList;

public abstract class Instrumento implements ApresentacaoMusical{

	protected String nome;
    protected ArrayList<Imagem> listaDeImagens = new ArrayList<Imagem>();
   
    public Instrumento(String nome) {
        this.nome = nome;
        this.listaDeImagens = new ArrayList<Imagem>();
    }
    
    public void tocarSom() {
        System.out.println("Tocando o som do instrumento: " + this.nome );
    }

    public void tocarExplanacao () {
    	System.out.println("Tocando a explanação sobre o instrumento: " + this.nome );
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Imagem> getListaDeImagens() {
		return listaDeImagens;
	}

	public void setListaDeImagens(ArrayList<Imagem> listaDeImagens) {
		this.listaDeImagens = listaDeImagens;
	}
  
}
