package br.ufrn.imd.lp2.modelo;

import java.util.Random;

public class Inimigo extends PersonagemBase {

    private double danoElemental;

    public Inimigo (Inimigo i) {
        super(i.getPontosDeVida(), i.getNome(), i.getRaca(),
                i.getArma().getDanoMinimo(), i.getArma().getDanoMaximo(),
                i.getArma().getNome(), i.getPocaoDeVida());
        danoElemental = i.getDanoElemental();
    }

    public Inimigo(int vida, String nome, String raca, int danoMin, int danoMax,
            String nomeArma, int pocao, double danoElemental) {
        super(vida, nome, raca, danoMin, danoMax, nomeArma, pocao);
        this.danoElemental = danoElemental;
    }

    @Override
    public int atacar(PersonagemBase target) {
        Random r = new Random();
        int dmgRange = getArma().getDanoMaximo() - getArma().getDanoMinimo();
        int baseDMG = r.nextInt(dmgRange) + getArma().getDanoMinimo();
        baseDMG = (int) (baseDMG * danoElemental);

        return baseDMG;
    }

    public double getDanoElemental() {
        return danoElemental;
    }
}
