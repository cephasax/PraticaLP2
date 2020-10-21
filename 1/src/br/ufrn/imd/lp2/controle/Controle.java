package br.ufrn.imd.lp2.controle;

import br.ufrn.imd.lp2.modelo.GrupoMusical;
import br.ufrn.imd.lp2.modelo.Instrumento;

public class Controle{

	public static void tocarTudoInstrumento (Instrumento instrumento) {
		System.out.println();
		System.out.println("Instrumento -> " + instrumento.getNome() );
		instrumento.tocarSom();
		instrumento.tocarExplanacao();
	}
	
	public static void tocarTudoGrupo (GrupoMusical grupo) {
		System.out.println();
		System.out.println("Grupo Musical -> " + grupo.getNome() );
		grupo.tocarApresentacaoMusical();
	}
	
}
