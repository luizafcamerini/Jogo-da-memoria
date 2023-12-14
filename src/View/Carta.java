package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;

class Carta extends JPanel implements MouseListener{
    private int x,y,w = 100,h = 100;
    private Color bordaCarta = new java.awt.Color(138, 205, 215);

    public Carta(int x, int y){
        this.x = x;
        this.y = y;
        setBounds(x,y,w,h);
        addMouseListener(this); // Adicione esta linha
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g); // Adicione esta linha
        Graphics2D g2d = (Graphics2D) g;
        RoundRectangle2D.Double r = new RoundRectangle2D.Double(0,0, w, h, 15, 15);
        g2d.setColor(Color.white);
        g2d.fill(r);
        g2d.setColor(bordaCarta);
        g2d.setStroke(new BasicStroke(10));
        g2d.draw(r);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("CLICOU");
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("ENTROU");
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
