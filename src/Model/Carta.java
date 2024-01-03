package Model;

import Observer.*;

class Carta implements Observado {
	private Simbolos simbolo;
	private boolean mostrada = false;

	public Carta(Simbolos simb) {
		this.simbolo = simb;
	}

	public Simbolos getSimbolo() {
		return this.simbolo;
	}

	public boolean getMostrada() {
		return this.mostrada;
	}

	public void setMostrada(boolean b) {
		this.mostrada = b;
	}

	public void addObservador(Observador o) {
	}

	public void removeObservador(Observador o) {
	}

	public int get(int i ){
		return 0;
	}
}
