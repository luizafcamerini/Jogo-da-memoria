package View;
import Model.ModelAPI;

public class ViewAPI {
    private static ViewAPI instance = null;
    private ModelAPI model;
    private String[] simbolos;

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

    public Carta[] criaBaralho(Painel p){
        Carta[] cartas = new Carta[20];
        
        for (int i = 0; i< cartas.length; i++){
            int x = (i % 5) * 120+180;
            int y = (i / 5) * 190;
            cartas[i] = new Carta(x, y);
            p.add(cartas[i]);
        }
        return cartas;
    }



}
