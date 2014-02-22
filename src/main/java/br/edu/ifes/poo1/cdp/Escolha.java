package br.edu.ifes.poo1.cdp;

public class Escolha {
	
	/**
	 * Trabalha com os princípios do algoritmo Minimax
	 * @param no
	 */
	public void maxMin(NoArvore no) {
		if (no.getNoPai().getTemValor() == true) {
			if (no.getNivel() == TipoNivel.MAX) {
				if (no.getNoPai().getValor() > no.getValor())
					no.getNoPai().setValor(no.getValor());
			} else {
				if (no.getNoPai().getValor() < no.getValor())
					no.getNoPai().setValor(no.getValor());
			}
		} else {
			no.getNoPai().setValor(no.getValor());
		}
		no.getNoPai().setTemValor();
	}
	
	/**
	 * Trabalha com os princípios da poda alfa beta
	 * @param no
	 * @return
	 */
	public boolean ehPoda(NoArvore no) {
		NoArvore noAncestral = no;
		if (no.getNivel() == TipoNivel.MIN) {
			while (noAncestral.temNoPai()) {
				noAncestral = noAncestral.getNoPai();
				if (noAncestral.getNivel() == TipoNivel.MAX
						& noAncestral.getTemValor() == true
						& noAncestral.getValor() >= no.getValor()) {
					return true;
				}
			}
		} else {
			while (noAncestral.temNoPai()) {
				noAncestral = noAncestral.getNoPai();
				if (noAncestral.getNivel() == TipoNivel.MIN
						& noAncestral.getTemValor() == true
						& noAncestral.getValor() <= no.getValor()) {
					return true;
				}
			}
		}
		return false;
	}
}
