package View;

import java.awt.Container;

import javax.swing.JFrame;

public class Tela extends JFrame{
    /** A tela é apenas a aba do jogo. Ela contém o Painel, onde realmente o jogo é mostrado.  */
    private Container container;

    public Tela(Painel p){
        setTitle("War");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,800);
		setResizable(false);
        setVisible(true);

        container = getContentPane();
        container.add(p);
    }

}
