package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ModelAPI {
    private static ModelAPI instance = null;
    private Jogo jogo;

    private ModelAPI(){}

    public static ModelAPI getInstance(){
        if (instance == null){
            instance = new ModelAPI();
        }
        return instance;
    }

    public void criaBaralho(){
        jogo.criaBaralho();
    }

    public void iniciaJogo(){
        jogo = new Jogo();
    }

    public ArrayList<String> getNomesSimbolos(){
        Simbolos[] simbolos = Simbolos.values();
        String [] nomes = new String[simbolos.length];
        for (int i = 0; i < simbolos.length; i++){
            nomes[i] = simbolos[i].toString();
        }
        ArrayList<String> temp = new ArrayList<>(Arrays.asList(nomes));
        Collections.shuffle(temp);
        return temp;
    }

}
