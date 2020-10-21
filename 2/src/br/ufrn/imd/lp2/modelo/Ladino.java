package br.ufrn.imd.lp2.modelo;

import java.util.Random;

import br.ufrn.imd.lp2.excecoes.ArmaErradaException;

public class Ladino extends PersonagemBase implements Fortificar {
    
	private boolean furtividade;
    private int multiplicador;

    public Ladino(int vida, String nome, String raca, int danoMin, int danoMax,
                  String nomeArma, int pocao) throws ArmaErradaException{
        
    	super(vida, nome, raca, danoMin, danoMax, nomeArma, pocao);
        
    	if(!(nomeArma.equals("Adaga")) && !(nomeArma.equals("Cimitarra"))) {
        	throw new ArmaErradaException("Ladino nao consegue usar " + nomeArma);
        }
    	
        furtividade = false;
        multiplicador = 10;
    }

    public void melhorarArma(int min, int max) {
        Arma arma = getArma();
        arma.setDanoMinimo(arma.getDanoMinimo() + min);
        arma.setDanoMaximo(arma.getDanoMaximo() + max);
        setArma(arma);
    }

    public void ativarEfeito() {
        furtividade = true;
    }

    public void desativarEfeito() {
        furtividade = false;
    }

    public int atacar(PersonagemBase target) {
        Random r = new Random();
        int dmgRange = getArma().getDanoMaximo() - getArma().getDanoMinimo();
        int baseDMG = r.nextInt(dmgRange) + getArma().getDanoMinimo();
        if (furtividade) {
            baseDMG = (int) (baseDMG * multiplicador);
        }
        return baseDMG;
    }

    public void abrirTesouro() {
        System.out.println(getNome() + " achou um tesouro!");
    }
}
