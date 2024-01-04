package View;

import java.awt.Color;

import javax.swing.JFrame;

public class Tela extends JFrame {
	private Color corFundo = new Color(255, 246, 246);

	public Tela(Painel p) {
		setTitle("Jogo da memória!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(corFundo);
		this.add(p);
		setVisible(true);
	}

}
