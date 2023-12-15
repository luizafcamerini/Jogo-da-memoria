package Model;

public class ModelAPI {
    private static ModelAPI instance = null;
    private Jogo jogo;
    private Simbolos simbolos;

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

    public String[] getNomesSimbolos(){
        String [] nomes = new String[Simbolos.values().length];
        for (int i = 0; i<nomes.length; i++){
            nomes[i] = Simbolos.values().toString();
        }
        return nomes;
    }

}
