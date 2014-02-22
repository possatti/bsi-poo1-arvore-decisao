package br.edu.ifes.poo1.app;

import br.edu.ifes.poo1.cci.Controlador;

public class Aplicacao {
	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		System.out.println("Se espera -19: "+controlador.caso1());
		System.out.println("Se espera 4: "+controlador.caso2());
	}
}
