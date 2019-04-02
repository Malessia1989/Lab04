package it.polito.tdp.lab04.controller;



	import java.net.URL;
	import java.util.ResourceBundle;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;
	import javafx.scene.input.MouseEvent;

	public class SegreteriaStudentiController {

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ComboBox<?> MenuTendina;

	    @FXML
	    private TextField txtMatricola;

	    @FXML
	    private TextField txtNome;

	    @FXML
	    private TextField txtCognome;

	    @FXML
	    private TextArea txtResult;

	    @FXML
	    void doCercaCorsi(ActionEvent event) {

	    }

	    @FXML
	    void doCercaIscritti(ActionEvent event) {

	    }

	    @FXML
	    void doCompleta(MouseEvent event) {

	    }

	    @FXML
	    void doIscrivi(ActionEvent event) {

	    }

	    @FXML
	    void doMenuTendina(ActionEvent event) {

	    }

	    @FXML
	    void doReset(ActionEvent event) {

	    }

	    @FXML
	    void initialize() {
	        assert MenuTendina != null : "fx:id=\"MenuTendina\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

	    }
	}

