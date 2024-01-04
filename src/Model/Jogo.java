package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Jogo {
	ArrayList<Carta> baralho;
	Stack<Carta> cartasMostradas;
	private final int NUM_CARTAS_SELEC = 2;

	public Jogo() {
		criaBaralho();
		System.out.println("Baralho criado.");
	}

	public ArrayList<Carta> criaBaralho() {
		baralho = new ArrayList<Carta>();
		cartasMostradas = new Stack<Carta>();
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < Simbolos.values().length; i++) {
				baralho.add(new Carta(Simbolos.values()[i]));
			}
		}
		Collections.shuffle(baralho);
		return baralho;
	}

	public boolean verificaCartasIguais(Carta c1, Carta c2) {
		return c1.getSimbolo() == c2.getSimbolo();
	}
}
