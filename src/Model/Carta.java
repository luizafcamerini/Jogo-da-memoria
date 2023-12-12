package Model;
import javax.swing.JPanel;

class Carta{
    private Simbolos simbolo;
    private boolean mostrada = false;

    public Carta(Simbolos simb){
        this.simbolo = simb;
    }

    public Simbolos getSimbolo(){
        return this.simbolo;
    }

    public boolean getMostrada(){
        return this.mostrada;
    }

    public void setMostrada(boolean b){
        this.mostrada = b;
    }
}
