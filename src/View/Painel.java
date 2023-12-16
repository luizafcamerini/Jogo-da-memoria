package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

class Painel extends JPanel implements MouseListener{
    private ArrayList<Carta> cartas;
    private ViewAPI view = ViewAPI.getInstance();

    public Painel(){
        setLayout(null);
        addMouseListener(this);
        cartas = view.criaBaralho(this);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}
