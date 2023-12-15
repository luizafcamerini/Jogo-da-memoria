package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;

class Carta extends JPanel implements MouseListener{
    private int x,y,w = 90,h = 170;
    private Color corSelecionada = new Color(248, 117, 170);
    private Color corDeselecionada = new Color(174, 222, 252);
    private Color corPreenchimento = Color.white;
    private Color corBorda = corDeselecionada;
    private boolean selecionada = false;
    private String simbolo;

    public Carta(int x, int y){
        this.x = x;
        this.y = y;
        setBounds(x,y,w,h);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        RoundRectangle2D.Double r = new RoundRectangle2D.Double(0,0, w, h, 20, 20);
        g2d.setColor(corPreenchimento);
        g2d.fill(r);
        if(selecionada){
            corBorda = corSelecionada;
        }
        else{
            corBorda = corDeselecionada;
        }
        g2d.setColor(corBorda);
        g2d.setStroke(new BasicStroke(15));
        g2d.draw(r);
        desenhaSimbolo(g2d);
    }

    private void desenhaSimbolo(Graphics2D g2d){
        int raio = 50;
        int xCentro = w/2-(raio/2);
        int yCentro = h/2-(raio/2);
        Ellipse2D.Double e = new Ellipse2D.Double(xCentro,yCentro,raio,raio);
        // switch (this.simbolo) {
        //     case value:
                
        //         break;
        
        //     default:
        //         break;
        // }
        g2d.setColor(new Color(248, 117, 170));
        g2d.fill(e);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void mouseClicked(MouseEvent e) {
        this.selecionada = !selecionada;
        repaint();
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        if (!selecionada){
            this.corPreenchimento = new Color(255, 246, 246);
        }
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        if (!selecionada){
            this.corPreenchimento = Color.white;
        }
        repaint();
    }

    public void setSelecionada(boolean b){
        this.selecionada = b;
    }

}
