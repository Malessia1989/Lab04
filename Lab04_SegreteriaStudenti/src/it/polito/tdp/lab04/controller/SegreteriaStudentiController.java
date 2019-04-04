package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SegreteriaStudentiController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> MenuTendina;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private ImageView btnCompleta;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	String matricola= txtMatricola.getText();
    	if(matricola != null && !matricola.isEmpty()) {
    		if(model.isDigit(matricola)) {
    			Studente s= model.getStudenteByID(matricola);
    			if(s != null) {
    				String elencoCorsi= model.getElencoCorsi(matricola);
    				txtResult.setText(elencoCorsi);
    			}else
    				showAlert("lo studente non esiste");
    		}else
    			showAlert("inserire un numero di 6 cifre");
    		
    	}else
    		showAlert("inserire un numero!");
    
    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	
    	Corso corsoSelezionato = MenuTendina.getValue();	//input
    	
    	if(corsoSelezionato != null) {
    		String elencoStudenti= model.getElencoStudenti(corsoSelezionato);
    		txtResult.setText(elencoStudenti);    		
    		
    	}else showAlert("selezionare un corso");
    	
    	
    }

    @FXML
    void doCompleta(MouseEvent event) {
    	
    	String matricola= txtMatricola.getText();
    	if(matricola != null && !matricola.isEmpty()) {
    		if(model.isDigit(matricola)) {
    			Studente s= model.getStudenteByID(matricola);
    			if(s != null) {
    				String nome= s.getNome();
    				String cognome=s.getCognome();
    				txtNome.setText(nome);
    				txtCognome.setText(cognome);
    				
    			}else
    				showAlert("lo studente non esiste");
    		}else
    			showAlert("inserire un numero di 6 cifre");
    		
    	}else
    		showAlert("inserire un numero!");
    	
    	
    
    }

    private void showAlert(String message) {
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(message);
		alert.show();

    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {
     	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtResult.clear();
    }

    @FXML
    void initialize() {
        assert MenuTendina != null : "fx:id=\"MenuTendina\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCompleta != null : "fx:id=\"btnCompleta\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        
        MenuTendina.getItems().addAll(Model.getAllCorsi());

    }

	public void setModel(Model model) {
		this.model=model;
	
		
	}
}


