package br.edu.ifes.poo1.cci;

import br.edu.ifes.poo1.cdp.NoArvore;
import br.edu.ifes.poo1.cgt.RealizaBusca;

public class Controlador {

	@SuppressWarnings("unused")
	public int caso1() {
		/**
		 * Cria nós em profundidade
		 */
		NoArvore no1 = new NoArvore(1);
		NoArvore no3 = new NoArvore(3, no1);
		NoArvore no2 = new NoArvore(2, no1);
		NoArvore no5 = new NoArvore(5, no2);
		NoArvore no4 = new NoArvore(4, no2);
		NoArvore no7 = new NoArvore(7, no3);
		NoArvore no6 = new NoArvore(6, no3);
		NoArvore no9 = new NoArvore(9, no4);
		NoArvore no8 = new NoArvore(8, no4);
		NoArvore no11 = new NoArvore(11, no5);
		NoArvore no10 = new NoArvore(10, no5);
		NoArvore no13 = new NoArvore(13, no6);
		NoArvore no12 = new NoArvore(12, no6);
		NoArvore no15 = new NoArvore(15, no7);
		NoArvore no14 = new NoArvore(14, no7);
		NoArvore no17 = new NoArvore(17, no8, 23);
		NoArvore no16 = new NoArvore(16, no8, 8);
		NoArvore no19 = new NoArvore(19, no9, 28);
		NoArvore no18 = new NoArvore(18, no9, -47);
		NoArvore no21 = new NoArvore(21, no10, -37);
		NoArvore no20 = new NoArvore(20, no10, -30);
		NoArvore no23 = new NoArvore(23, no11, -41);
		NoArvore no22 = new NoArvore(22, no11, 3);
		NoArvore no25 = new NoArvore(25, no12, 4);
		NoArvore no24 = new NoArvore(24, no12, -19);
		NoArvore no27 = new NoArvore(27, no13, 4);
		NoArvore no26 = new NoArvore(26, no13, -49);
		NoArvore no29 = new NoArvore(29, no14, 45);
		NoArvore no28 = new NoArvore(28, no14, 43);
		NoArvore no31 = new NoArvore(31, no15, -14);
		NoArvore no30 = new NoArvore(30, no15, -26);

		// Cria variável objeto pra visualizar a arvore
		RealizaBusca va = new RealizaBusca();

		// Realiza a busca em profundidade
		va.buscaEmProfundidade(no1);
		
		return no1.getValor();
	}

	@SuppressWarnings("unused")
	public int caso2() {
		/**
		 * Cria nós em profundidade
		 */
		NoArvore no1 = new NoArvore(1);
		NoArvore no4 = new NoArvore(4, no1);
		NoArvore no3 = new NoArvore(3, no1);
		NoArvore no2 = new NoArvore(2, no1);
		NoArvore no7 = new NoArvore(7, no2, 4);
		NoArvore no6 = new NoArvore(6, no2, 2);
		NoArvore no5 = new NoArvore(5, no2, 10);
		NoArvore no10 = new NoArvore(10, no3, 4);
		NoArvore no9 = new NoArvore(9, no3, 5);
		NoArvore no8 = new NoArvore(8, no3, 4);
		NoArvore no13 = new NoArvore(13, no3, 9);
		NoArvore no12 = new NoArvore(12, no3, 5);
		NoArvore no11 = new NoArvore(11, no3, 6);

		// Cria variável objeto pra visualizar a arvore
		RealizaBusca va = new RealizaBusca();

		// Realiza a busca em profundidade
		va.buscaEmProfundidade(no1);

		return no1.getValor();		
	}

}