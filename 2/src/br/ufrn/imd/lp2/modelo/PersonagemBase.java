package br.ufrn.imd.lp2.modelo;

import static java.lang.Math.min;

public abstract class PersonagemBase {
    
	private int pontosDeVida;
    private int vidaMaxima;
    private String nome;
    private String raca;
    private Arma arma;
    private int pocaoDeVida;
    private boolean vivo;

    public PersonagemBase(int health, String nome, String raca, int minDmg,
                          int maxDmg, String nameWeapon, int potions) {
        pontosDeVida = health;
        vidaMaxima = pontosDeVida;
        this.nome = nome;
        this.raca = raca;
        this.arma = new Arma(nameWeapon, minDmg, maxDmg);
        pocaoDeVida = potions;
        vivo = true;
    }

    public void pocaoDeVida() {
        if (pocaoDeVida > 0) {
            pocaoDeVida--;
            pontosDeVida = (int) min(vidaMaxima * 0.35 + pontosDeVida,
            		vidaMaxima);
        }
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public String getNome() {
        return nome;
    }

    public int getPocaoDeVida() {
        return pocaoDeVida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public String getRaca() {
        return raca;
    }

    public void status() {
        System.out.println(String.format("%13s", getNome()) +
                "\tHP: " + String.format("%7s", getPontosDeVida() + " / " +
                getVidaMaxima()) + String.format("%20s",
                "Pocoees de vida: ") + getPocaoDeVida());
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo() {
        if (pontosDeVida > 0) {
            vivo = true;
        } else {
            vivo = false;
        }
    }

    public void tomarDano(int dano) {
        pontosDeVida -= dano;
        setVivo();
    }

    public abstract int atacar(PersonagemBase target);
}
