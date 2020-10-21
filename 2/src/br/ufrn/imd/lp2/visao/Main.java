package br.ufrn.imd.lp2.visao;

import java.util.ArrayList;

import br.ufrn.imd.lp2.controle.BatalhaControle;
import br.ufrn.imd.lp2.excecoes.ArmaErradaException;
import br.ufrn.imd.lp2.modelo.Barbaro;
import br.ufrn.imd.lp2.modelo.Inimigo;
import br.ufrn.imd.lp2.modelo.Ladino;
import br.ufrn.imd.lp2.modelo.Necromante;
import br.ufrn.imd.lp2.modelo.PersonagemBase;

public class Main {

    public static void main(String[] args) {
        
    	ArrayList<PersonagemBase> herois = new ArrayList<PersonagemBase>();
        // Creating the heroes Conan (Barbarian), Cormac (Rogue) and
        // Sammaster (Necromancer)
        PersonagemBase conan = null;
		
        try {
			conan = new Barbaro(22, "Conan",
			        "Humano", 2, 6, "Machado",
			        2);
		} catch (ArmaErradaException e) {
			e.printStackTrace();
			System.exit(1);
		}
        
        PersonagemBase cormac = null;
        
		try {
			cormac = new Ladino(15, "Shey Cormac",
			        "Humano", 2, 4, "Cimitarra",
			        3);
		} catch (ArmaErradaException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
        PersonagemBase sammaster = null;
        
		try {
			sammaster = new Necromante(16,
			        "Sammaster", "Humano", 1, 3,
			        "Cajado", 1);
		} catch (ArmaErradaException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
        herois.add(conan);
        herois.add(cormac);
        herois.add(sammaster);

        // Creating the Enemies Goblins, King Ork and a Elf to test the battle
        // mechanic
        ArrayList<PersonagemBase> inimigos = new ArrayList<PersonagemBase>();
        PersonagemBase goblin = new Inimigo(10, "Goblin",
                "Orc", 1, 4, "Massa",
                1, 1.3);

        PersonagemBase kingOrk = new Inimigo(15, "Rei Orc",
                "Ork", 1, 4, "Maça",
                1, 1.3);

        PersonagemBase elf = new Inimigo(20, "Sentinela",
                "Elfo", 3, 6, "Arco",
                2, 2);

        inimigos.add(goblin);
//        inimigos.add(new Inimigo((Inimigo) goblin));
//        inimigos.add(new Inimigo((Inimigo) goblin));
//        inimigos.add(new Inimigo((Inimigo) goblin));
//        inimigos.add(new Inimigo((Inimigo) goblin));
//        inimigos.add(kingOrk);
//        inimigos.add(elf);

        System.out.println("Iniciando a Batalha");
        BatalhaControle batalha = new BatalhaControle(herois, inimigos);

        batalha.batalhar();
    }
}
