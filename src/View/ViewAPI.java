package View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Model.ModelAPI;

public class ViewAPI {
    private static ViewAPI instance = null;
    private ModelAPI model;
    private ArrayList<String> simbolos;
    private int numCartas = 20;

    Carta cartas[];

    private ViewAPI(){
        model = ModelAPI.getInstance();
        simbolos = model.getNomesSimbolos();
    }

    public static ViewAPI getInstance(){
        if (instance == null){
            instance = new ViewAPI();
        }
        return instance;
    }

    public void criaTela(){
        new Tela(new Painel());
    }

    public ArrayList<Carta> criaBaralho(Painel p){
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        ArrayList<Integer> coordenadasX = new ArrayList<Integer>();
        ArrayList<Integer> coordenadasY = new ArrayList<Integer>();
        Random random = new Random();

        // Guardando as coordenadas em dois vetores:
        for (int i = 0; i< numCartas; i++){
            int x = (i % 5) * 120+180;
            int y = (i / 5) * 190;
            coordenadasX.add(x);
            coordenadasY.add(y);
        }

        // Escolhendo randomicamente as coordenadas para cada carta e criando as cartas
        for (int i = 0; i< numCartas; i++){
            int xRandom = (random.nextInt(coordenadasX.size()));
            int yRandom = xRandom; // Os indices de X e Y precisam ser iguais
            cartas.add(new Carta(coordenadasX.get(xRandom), coordenadasY.get(yRandom), simbolos.get(i%(numCartas/2))));
            // Remove as coordenadas usadas para que nao haja cartas com sobreposicao
            coordenadasX.remove(xRandom);
            coordenadasY.remove(yRandom);
        }
        Collections.shuffle(cartas);
        adicionaCartas(p,cartas);
        return cartas;
    }

    private void adicionaCartas(Painel p, ArrayList<Carta> cartas){
        for (int i = 0; i<cartas.size(); i++){
            p.add(cartas.get(i));
            System.out.printf("%s\n", cartas.get(i).getSimbolo().toString());
        }
    }

    public ArrayList<String> getNomeSimbolos(){
        return model.getNomesSimbolos();
    }

}
