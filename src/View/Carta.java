package View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class Carta extends JComponent{
    private int x,y;

    public Carta(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double r = new Rectangle2D.Double(x,y,100,100);
        g2d.setColor(Color.BLUE);
        g2d.fill(r);
    }

}
