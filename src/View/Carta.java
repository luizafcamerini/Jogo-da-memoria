package View;

import Observer.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;

class Carta extends JPanel implements MouseListener, Observador,Observado{
    private int x,y, w = 90, h = 170;
    private Color corSelecionada = new Color(248, 117, 170);
    private Color corDeselecionada = new Color(174, 222, 252);
    private Color corSimbolos = new Color(248, 117, 170);
    private Color corPreenchimento = Color.white;
    private Color corBorda = corDeselecionada;
    private boolean selecionada = false;
    private boolean mostrada = false;
    private String simbolo;

    public Carta(int x, int y,String simbolo){
        this.x = x;
        this.y = y;
        this.simbolo = simbolo;
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
        if (!mostrada){
            if (!selecionada) {
                return;
            }
        }
        g2d.setColor(corSimbolos);
        int raio = 50;
        int xCentro = w/2-(raio/2);
        int yCentro = h/2-(raio/2);
        switch (this.simbolo) {
            case "CIRCULO":
                Ellipse2D.Double e = new Ellipse2D.Double(xCentro,yCentro,raio,raio);
                g2d.fill(e);
                break;
            
            case "QUADRADO":
                Rectangle2D.Double quadrado = new Rectangle2D.Double(w/4,h/3,w/2,w/2);
                g2d.fill(quadrado);
                break;

            case "TRIANGULO":
                Path2D path = new Path2D.Double();
                double lado = h/4 * 0.8; // Comprimento do lado do triângulo (80% do menor lado)
                double x1 = (w - lado) / 2;
                double y1 = h / 2 + (Math.sqrt(3) / 6) * lado;

                double x2 = x1 + lado / 2;
                double y2 = y1 - (Math.sqrt(3) / 3) * lado;

                double x3 = x1 + lado;
                double y3 = y1;

                path.moveTo(x1, y1);
                path.lineTo(x2, y2);
                path.lineTo(x3, y3);
                path.closePath();
                g2d.draw(path);
                g2d.fill(path);
                break;
            
            case "RETANGULO":
                Rectangle2D.Double retangulo = new Rectangle2D.Double(w/4,h/4,w/2,h/2);
                g2d.fill(retangulo);
                break;

            default:
                break;
        }
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String getSimbolo(){
        return this.simbolo;
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

    public void addObservador(Observador o) {
    }

    public void removeObservador(Observador o) {
    }

    public void notify(Observado o) {
    }

}
