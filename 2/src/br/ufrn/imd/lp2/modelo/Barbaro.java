package br.ufrn.imd.lp2.modelo;

import java.util.Random;

import br.ufrn.imd.lp2.excecoes.ArmaErradaException;

public class Barbaro extends PersonagemBase implements Fortificar {

    private boolean furia;

    public Barbaro(int vida, String nome, String raca, int danoMin, int danoMax,
                   String nomeArma, int pocao) throws ArmaErradaException{
        super(vida, nome, raca, danoMin, danoMax, nomeArma, pocao);
        if(!(nomeArma.contentEquals("Machado"))) {
        	throw new ArmaErradaException("Barbaro nao consegue usar " + nomeArma);
        }
        furia = false;
    }

    public void melhorarArma(int min, int max) {
        Arma arma = getArma();
        arma.setDanoMinimo(arma.getDanoMinimo() + min);
        arma.setDanoMaximo(arma.getDanoMaximo() + max);
        setArma(arma);
    }

    public void ativarEfeito() {
        furia = true;
    }

    public void desativarEfeito() {
        furia = false;
    }

    public int atacar(PersonagemBase target) {
        Random r = new Random();
        int dmgRange = getArma().getDanoMaximo() - getArma().getDanoMinimo();
        int baseDMG = r.nextInt(dmgRange) + getArma().getDanoMinimo();
        if (furia) {
            baseDMG = (int) (baseDMG * 1.5);
        }

        return baseDMG;
    }
}
