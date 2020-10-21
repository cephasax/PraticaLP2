package br.ufrn.imd.lp2.modelo;

import java.util.Random;

import br.ufrn.imd.lp2.excecoes.ArmaErradaException;

public class Necromante extends PersonagemBase implements Fortificar {
	
	private boolean rouboDeVida;
	private double frio = 1.1;

	public Necromante(int vida, String nome, String raca, int danoMin, int danoMax, String nomeArma, int pocao)
			throws ArmaErradaException {

		super(vida, nome, raca, danoMin, danoMax, nomeArma, pocao);

		if (!(nomeArma.equals("Cajado"))) {
			throw new ArmaErradaException("Necromante nao consegue usar " + nomeArma);
		}

		rouboDeVida = false;
	}

	public void melhorarArma(int min, int max) {
		Arma arma = getArma();
		arma.setDanoMinimo(arma.getDanoMinimo() + min);
		arma.setDanoMaximo(arma.getDanoMaximo() + max);
		setArma(arma);
	}

	public void ativarEfeito() {
		rouboDeVida = true;
	}

	public void desativarEfeito() {
		rouboDeVida = false;
	}

	public int atacar(PersonagemBase target) {
		Random r = new Random();
		int dmgRange = getArma().getDanoMaximo() - getArma().getDanoMinimo();
		int baseDMG = r.nextInt(dmgRange) + getArma().getDanoMinimo();
		baseDMG = (int) (baseDMG * frio);
		if (rouboDeVida) {

		}
		return baseDMG;
	}

	public void escudoMagico() {
		System.out.println(getNome() + " cria um escudo Magico!");
	}
}
