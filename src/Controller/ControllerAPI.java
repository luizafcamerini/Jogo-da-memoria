package Controller;

import java.util.ArrayList;

import Model.ModelAPI;
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
		iniciaJogo();
	}

	public ArrayList<String> getNomesSimbolos(){
		return model.getNomesSimbolos();
	}

	public void iniciaJogo() {
		model.iniciaJogo();
		// view.criaTela();
	}

	public void criaTela(){
		view.criaTela();
	}

}
