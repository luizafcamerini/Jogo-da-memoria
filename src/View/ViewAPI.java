package View;

import java.awt.geom.*;
import javax.swing.*;

public class ViewAPI {
    private static ViewAPI instance = null;

    Carta cartas[] = new Carta[5];

    private ViewAPI(){}

    public static ViewAPI getInstance(){
        if (instance == null){
            instance = new ViewAPI();
        }
        return instance;
    }

    public void criaTela(){
        Painel p = new Painel();
        Tela t = new Tela(p);
    }

}
