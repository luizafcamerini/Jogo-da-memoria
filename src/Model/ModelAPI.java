package Model;

import Controller.ControllerAPI;

public class ModelAPI {
    private static ModelAPI instance = null;
    private ControllerAPI c = null;

    private ModelAPI(){}

    public static ModelAPI getInstance(){
        if (instance == null){
            instance = new ModelAPI();
        }
        return instance;
    }

    public void iniciaJogo(){
        Jogo jogo = new Jogo();
    }
}
