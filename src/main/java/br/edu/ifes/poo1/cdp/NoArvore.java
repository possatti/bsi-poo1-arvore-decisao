package br.edu.ifes.poo1.cdp;

import java.util.ArrayList;

public class NoArvore {

	// Indice de um nó
	private int indice;

	// Nó que é pai do nó em questão
	private NoArvore noPai;

	// Valor de um nó
	private int valor;

	// Indica se o nó em questão já possui algum valor
	private boolean temValor;

	// Cada nó terá uma lista de adjacência indicando seus nós de ligação direta
	private ArrayList<NoArvore> listaAdjacencia = new ArrayList<NoArvore>();

	// Irá servir para indicar a posição na lista de adjacência de um nó
	private int posicaoListaAdjacencia;

	// Marca o nó como visitado
	private boolean marcado;

	// Se o nó se encontra no nível max ou min
	private TipoNivel nivel;

	// Irá refletir se o nó foi podado ou não
	private boolean podou;

	/**
	 * Classe construtora de nó raiz
	 * 
	 * @param noPai
	 * @param valor
	 */
	public NoArvore(int indice) {
		this.indice = indice;
		this.noPai = null;
		this.temValor = false;
		this.insereListaAdjacencia(noPai);
		this.posicaoListaAdjacencia = 0;
		this.marcado = false;
		this.nivel = TipoNivel.MAX;
		this.podou = false;
	}

	/**
	 * Classe construtora de nó
	 * 
	 * @param noPai
	 * @param valor
	 */
	public NoArvore(int indice, NoArvore noPai) {
		this.indice = indice;
		this.noPai = noPai;
		noPai.addFilho(this);
		this.temValor = false;
		this.insereListaAdjacencia(noPai);
		this.posicaoListaAdjacencia = this.getNoPai().getListaAdjacencia()
				.size();
		this.marcado = false;
		this.nivel = coloqueNivel();
		this.podou = false;
	}

	/**
	 * Classe construtora de nó folha
	 * 
	 * @param indice
	 * @param valor
	 */
	public NoArvore(int indice, NoArvore noPai, int valor) {
		this.indice = indice;
		this.noPai = noPai;
		noPai.addFilho(this);
		this.valor = valor;
		this.temValor = true;
		this.insereListaAdjacencia(noPai);
		this.posicaoListaAdjacencia = this.getNoPai().getListaAdjacencia()
				.size();
		this.marcado = false;
		this.nivel = coloqueNivel();
		this.podou = false;
	}

	/**
	 * Pegar o indice de um nó
	 * 
	 * @return
	 */
	public int getIndice() {
		return this.indice;
	}

	/**
	 * Pegar o valor de um nó
	 * 
	 * @return
	 */
	public int getValor() {
		return this.valor;
	}

	/**
	 * Modifica o valor de um nó
	 * 
	 * @param valor
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * Verifica se o nó possui valor ou não
	 * 
	 * @return
	 */
	public boolean getTemValor() {
		return this.temValor;
	}

	/**
	 * Muda o estado o nó quando ele receber um valor
	 */
	public void setTemValor() {
		this.temValor = true;
	}

	/**
	 * Retorna se um nó possui nó pai
	 * 
	 * @return
	 */
	public boolean temNoPai() {
		return (this.getNoPai() != null);
	}

	/**
	 * Retorna o nó pai de um nó
	 * 
	 * @return
	 */
	public NoArvore getNoPai() {
		// Se o nó possui pai
		if (this.noPai != null)
			return noPai;
		return null;
	}

	/**
	 * Retorna se um nó possui nós filhos
	 * 
	 * @return
	 */
	public boolean temNoFilho() {
		// Se não for o nó raiz
		if (this.temNoPai()) {
			if (this.getListaAdjacencia().size() > 2)
				return true;
			// Se for o nó raiz
		} else {
			if (this.getListaAdjacencia().size() > 1)
				return true;
		}
		return false;
	}

	/**
	 * Pega o valor do primeiro nó filho
	 * 
	 * @return
	 */
	public NoArvore getPrimeiroFilho() {
		// Se o nó possui filhos..
		if (this.temNoFilho() == true)
			return this.listaAdjacencia.get(1);
		return null;
	}

	/**
	 * Gera um nó filho a um nó
	 * 
	 * @param no
	 */
	public void addFilho(NoArvore no) {
		// Adiciona na lista de adjacências
		this.insereListaAdjacencia(no);
	}

	/**
	 * Verifica se o nó possui irmãos
	 * 
	 * @return
	 */
	public boolean aindaPossuiIrmao() {
		int posicao = this.posicaoListaAdjacencia - 1;
		int i;
		for (i = 0; i < this.getNoPai().getListaAdjacencia().size(); i++)
			if (this.getNoPai().getListaAdjacencia().get(i) != null)
				if (posicao == 1)
					return false;
		return true;
	}

	/**
	 * Recupera a lista de adjacência de um nó
	 * 
	 * @return
	 */
	public ArrayList<NoArvore> getListaAdjacencia() {
		return this.listaAdjacencia;
	}

	/**
	 * Insere um nó na lista de adjacência de outro nó
	 * 
	 * @param no
	 */
	public void insereListaAdjacencia(NoArvore no) {
		this.getListaAdjacencia().add(no);
	}

	/**
	 * Verifica se o nó já foi marcado como visitado
	 * 
	 * @return
	 */
	public boolean isMarcado() {
		return marcado;
	}

	/**
	 * Marca nó como visitado
	 */
	public void marcaNo() {
		this.marcado = true;
	}

	/**
	 * Pega o nível que um nó se encontra "Max/min"
	 * 
	 * @return
	 */
	public TipoNivel getNivel() {
		return this.nivel;
	}

	/**
	 * Coloca o nível em um nó, com base no nó do pai
	 * 
	 * @param nivelNoPai
	 * @return
	 */
	public TipoNivel coloqueNivel() {
		if (this.getNoPai().getNivel() == TipoNivel.MAX)
			return TipoNivel.MIN;
		return TipoNivel.MAX;
	}

	/**
	 * Vê se um nó voi podado
	 * 
	 * @return
	 */
	public boolean getPodou() {
		return podou;
	}

	/**
	 * Poda os filhos de um nó
	 */
	public void podaFilhos() {
		int i;
		for (i = 1; i < this.getListaAdjacencia().size(); i++) {
			this.getListaAdjacencia().get(i).marcaNo();
			this.getListaAdjacencia().get(i).podou = true;
		}
	}

}
