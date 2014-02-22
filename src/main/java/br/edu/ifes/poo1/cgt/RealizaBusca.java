package br.edu.ifes.poo1.cgt;

import java.util.Stack;

import br.edu.ifes.poo1.cdp.Escolha;
import br.edu.ifes.poo1.cdp.NoArvore;

public class RealizaBusca {

	private Escolha escolha = new Escolha();

	// Cria uma pilha
	private Stack<NoArvore> pilha = new Stack<NoArvore>();

	/**
	 * Realiza uma busca em profundidade na árvore
	 * 
	 * @param raiz
	 */
	public void buscaEmProfundidade(NoArvore raiz) {
		// Pilha recebe o nó raiz
		pilha.push(raiz);
		// Enquanto a pilha nóo estiver vazia
		while (pilha.isEmpty() == false) {
			// Pegue um nó da pilha
			NoArvore no = pilha.pop();
			// Se o nó já possui valor e possui pai
			if (no.getTemValor() == true && no.temNoPai() == true
					&& no.getPodou() == false) {
				// Encontre o maxMin do seu pai
				this.escolha.maxMin(no);
				// Realize a poda
				// Se ocorreu uma poda
				if (this.escolha.ehPoda(no.getNoPai()))
					// Pode os nós filhos
					no.getNoPai().podaFilhos();
			}
			// Se o nó ainda nóo foi marcado (visitado)
			if (no.isMarcado() == false) {
				// Marque o nó
				no.marcaNo();
				// Se o nó possuir pai
				if (no.temNoPai() == true)
					// Se nó nóo possuir mais irmãos, coloque o pai novamente
					// na pilha
					if (no.aindaPossuiIrmao() == false)
						// if (no.getFilho().isMarcado() == false)
						pilha.push(no.getListaAdjacencia().get(0));
				// Coloque todos os filhos do nó na pilha
				for (int indice = 1; indice < no.getListaAdjacencia().size(); indice++) {
					pilha.push(no.getListaAdjacencia().get(indice));
				}
			}
		}
	}

}
