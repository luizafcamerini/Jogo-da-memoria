package Model;

import Observer.*;

class Carta implements Observado {
	private Simbolos simbolo;
	private boolean selecionada = false;
	private Observador observador;

	/* Esse status é usado no model para definir a visualização da carta. */
	private final int STATUS_ESCONDIDA = 0;
	private final int STATUS_SELECIONADA = 1;
	private final int STATUS_DESCOBERTA = 2;
	private int status = STATUS_ESCONDIDA;

	public Carta(Simbolos simb) {
		this.simbolo = simb;
	}

	public Simbolos getSimbolo() {
		return this.simbolo;
	}

	public boolean getSelecioanda() {
		return this.selecionada;
	}

	public void setSelecioanda(boolean b) {
		this.selecionada = b;
	}

	public void addObservador(Observador o) {
		this.observador = o;
	}

	public void removeObservador(Observador o) {
		this.observador = null;
	}

	public int get(int i){
		return 0;
	}
}
