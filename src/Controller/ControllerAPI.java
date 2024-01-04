package Controller;

import java.util.ArrayList;

import Model.ModelAPI;
import Observer.*;
import View.ViewAPI;

public class ControllerAPI {
	private static ControllerAPI instance;
	private ModelAPI model;
	private ViewAPI view;

	private ControllerAPI() {
	}

	public static ControllerAPI getInstance() {
		if (instance == null) {
			instance = new ControllerAPI();
		}
		return instance;
	}

	public void inicia() {
		instance.model = ModelAPI.getInstance();
		instance.view = ViewAPI.getInstance();
		model.iniciaJogo();
		// registraCartaModelView(null, null);
		view.criaTela();
	}

	public ArrayList<String> getNomesSimbolos(){
		return model.getNomesSimbolos();
	}

	public void registraCartaModelView(Observador cartaObservadora, Observado cartaObservada){
		cartaObservada.addObservador(cartaObservadora);
	}
}
