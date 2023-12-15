package View;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

class Painel extends JPanel implements MouseListener{
    private Carta[] cartas;
    // private Carta c;

    public Painel(){
        setLayout(null);
        // c = new Carta(100, 100);
        addMouseListener(this);
        cartas = new Carta[20];
        
        for (int i = 0; i< cartas.length; i++){
            int x = (i % 5) * 120+180;
            int y = (i / 5) * 190;
            cartas[i] = new Carta(x, y);
            // System.out.printf("X: %d Y: %d\n",cartas[i].getX(), cartas[i].getY());
            this.add(cartas[i]);
        }
    }

    public void paintComponent(Graphics g){
    }

    public void mouseClicked(MouseEvent e) {
        // System.out.println("CLICOU NO PAINEL");
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        // System.out.println("ENTROU NO PAINEL");
    }

    public void mouseExited(MouseEvent e) {
    }

}
