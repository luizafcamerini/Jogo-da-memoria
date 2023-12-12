package Controller;

import Model.ModelAPI;
import View.ViewAPI;

public class ControllerAPI {
    private static ControllerAPI instance = null;
    private ModelAPI model = null;
    private ViewAPI view = null;

    public static void main(String[] args) {
        ControllerAPI control = ControllerAPI.getInstance();
        control.iniciaJogo();
    }

    private ControllerAPI(){
        model = ModelAPI.getInstance();
        view = ViewAPI.getInstance();
    }

    static ControllerAPI getInstance(){
        if (instance == null){
            instance = new ControllerAPI();
        }
        return instance;
    }

    public void iniciaJogo(){
        // model.iniciaJogo();
        view.criaTela();
    }

}
