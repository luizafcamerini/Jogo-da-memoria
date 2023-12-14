package View;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

class Painel extends JPanel implements MouseListener{
    private Carta[] cartas;
    private Carta c;

    public Painel(){
        setLayout(null); // Adicione esta linha
        c = new Carta(100, 100);
        // c.setBounds(0, 100, 100, 100); // Adicione esta linha
        addMouseListener(this);
        this.add(c); // Adicione esta linha
    }

    public void paintComponent(Graphics g){
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("CLICOU NO PAINEL");
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("ENTROU NO PAINEL");
    }

    public void mouseExited(MouseEvent e) {
    }

}
