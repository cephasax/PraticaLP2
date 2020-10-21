package br.ufrn.imd.lp2.controle;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import br.ufrn.imd.lp2.modelo.Barbaro;
import br.ufrn.imd.lp2.modelo.Ladino;
import br.ufrn.imd.lp2.modelo.Necromante;
import br.ufrn.imd.lp2.modelo.PersonagemBase;

public class BatalhaControle {
    
	private ArrayList<PersonagemBase> herois;
    private ArrayList<PersonagemBase> inimigos;
    private int contHeroi = 0;
    private int contInimigo = 0;
    private boolean heroi = true;
    private String divider = String.format("%80s","").replace(" ", "-");

    public BatalhaControle (ArrayList<PersonagemBase> herois,
                    ArrayList<PersonagemBase> inimigos) {
        this.herois = herois;
        this.inimigos = inimigos;
        turnos();
    }

    public void removeMorto(ArrayList<PersonagemBase> aux) {
        aux.removeIf(p -> p.getPontosDeVida() < 1);
    }

    public void estado() {
        for (PersonagemBase heroi : herois) {
            heroi.status();
        }
        System.out.println(divider);
        for (PersonagemBase inimigo : inimigos) {
            inimigo.status();
        }
    }

    public void escolherAcao(PersonagemBase personagem) {
        System.out.println(divider);
        System.out.println("Vez de **" + personagem.getNome() + "**");
        if (herois.contains(personagem)) { //checando se o personagem da vez e um heroi
            Scanner sc = new Scanner(System.in);
            System.out.println("1 - Atacar Inimigo\n2 - Melhorar Arma\n3 - " +
                    "Ativar/Desativar Efeito\n4 - Usar Pocao");
            int op = 0;
            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.err.println("Nao foi possivel converter a opcao");
            }
            switch (op) { //aplicando as opcoes de acao possiveis para os personagens
                case 1: //atacando
                    int alvo = -1;
                    System.out.println("Selecione um inimigo entre 1 e " +
                            inimigos.size());
                    try {
                        alvo = Integer.parseInt(sc.nextLine()) - 1;
                    } catch (Exception e) {
                        System.err.println("Nao foi possivel converter a opcao");
                    }
                    int dano = personagem.atacar(inimigos.get(alvo));
                    inimigos.get(alvo).tomarDano(dano);
                    break;
                case 2: //melhorando arma
                    if (personagem instanceof Barbaro) {
                        personagem = ((Barbaro) personagem);
                        ((Barbaro) personagem).melhorarArma(2, 2);
                    } else if (personagem instanceof Ladino) {
                        personagem = ((Ladino) personagem);
                        ((Ladino) personagem).melhorarArma(1, 2);
                    } else {
                        personagem = ((Necromante) personagem);
                        ((Necromante) personagem).melhorarArma(1, 1);
                    }
                    break;
                case 3: //ativando efeito
                    if (personagem instanceof Barbaro) {
                        personagem = ((Barbaro) personagem);
                        ((Barbaro) personagem).ativarEfeito();
                    } else if (personagem instanceof Ladino) {
                        personagem = ((Ladino) personagem);
                        ((Ladino) personagem).ativarEfeito();
                    } else {
                        personagem = ((Necromante) personagem);
                        ((Necromante) personagem).ativarEfeito();
                    }
                    break;
                case 4: //usando pocao de vida
                    personagem.pocaoDeVida();
                    break;
                default:
                    throw new IllegalStateException("Digite valores entre" +
                            " 1 - 4");
            }
        } else { //caso o personagem da vez seja um inimigo a unica opcao e o ataque
            Random r = new Random();
            int alvo = r.nextInt(herois.size());
            int dano = personagem.atacar(herois.get(alvo));
            herois.get(alvo).tomarDano(dano);
        }
    }

    public int vitoria() {
        if (herois.size() == 0){
            System.out.println("Herois Derrotados");
            return -1;
        } else if (inimigos.size() == 0) {
            System.out.println("Herois Ganharam");
            return 1;
        } else {
            return 0;
        }
    }

    public void batalhar() {
        estado();
        while (vitoria() == 0) {
            PersonagemBase vez = turnos(); // selecionando o personagem da vez
            escolherAcao(vez);
            removeMorto(herois);
            removeMorto(inimigos);
            estado();
        }
    }

    private PersonagemBase turnos() {
        PersonagemBase turno;
        if (heroi) { // caso a vez seja de um heroi
            heroi = false; // a proxima vez sera de um inimigo
            turno = herois.get(contHeroi); // selecionando o n-esimo heroi da lista de herois (n = contHeroi)
            contHeroi++;
        } else { // caso a vez seja de um inimigo
            heroi = true; // a proxima vez sera de um heroi
            turno = inimigos.get(contInimigo); // selecionando o n-esimo inimigo da lista de inimigos (n = contInimigo)
            contInimigo++; 
        }
        if (contHeroi > (herois.size() - 1)) {
            contHeroi = 0;
        }
        if (contInimigo > (inimigos.size() - 1)) {
            contInimigo = 0;
        }
        return turno;
    }
}
