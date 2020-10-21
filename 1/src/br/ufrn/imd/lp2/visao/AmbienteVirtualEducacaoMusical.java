package br.ufrn.imd.lp2.visao;

import java.util.ArrayList;

import br.ufrn.imd.lp2.controle.Controle;
import br.ufrn.imd.lp2.excecoes.TipoInvalidoMelodicoException;
import br.ufrn.imd.lp2.modelo.GrupoMusical;
import br.ufrn.imd.lp2.modelo.Harmonico;
import br.ufrn.imd.lp2.modelo.Instrumento;
import br.ufrn.imd.lp2.modelo.Melodico;
import br.ufrn.imd.lp2.modelo.Percussao;

public class AmbienteVirtualEducacaoMusical {
    
	public static void main(String[] args) {
        
    	ArrayList<Instrumento> instrumentos = new ArrayList<Instrumento>();
    	ArrayList<GrupoMusical> grupos = new ArrayList<GrupoMusical>();
    	Melodico m1 = null;
    	
    	try {
			m1 = new Melodico("Saxofone tenor", "si bemol", "Fa sustenido", "palhetas");
		} catch (TipoInvalidoMelodicoException e) {
			e.printStackTrace();
		}
    	
    	Harmonico h1 = new Harmonico("Harpa", "do", "do");
    	Percussao p1 = new Percussao("atabaque");
    	
    	instrumentos.add(m1);
    	instrumentos.add(h1);
    	instrumentos.add(p1);
    	
    	GrupoMusical g1 = new GrupoMusical("Forro Mastruz com Leite");
    	GrupoMusical g2 = new GrupoMusical("Arturo Sandoval");
    	
    	grupos.add(g1);
    	grupos.add(g2);
    	
    	
    	System.out.println("------------");
    	System.out.println("Inicio");
    	System.out.println("------------\n");
    	
    	for(Instrumento i: instrumentos) {
    		Controle.tocarTudoInstrumento(i);
    		i.tocarApresentacaoMusical();
    	}
    	
    	for(GrupoMusical g: grupos) {
    		Controle.tocarTudoGrupo(g);
    	}
    	
    	System.out.println("\n------------");
    	System.out.println("Fim");
    	System.out.println("------------\n");
    }
}
