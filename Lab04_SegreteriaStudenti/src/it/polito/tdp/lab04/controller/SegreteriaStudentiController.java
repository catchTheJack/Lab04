package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	Model model = new Model();
	
	public void setModel(Model model) {
		this.model = model;
		comboBox.setItems(model.getComboBox());
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Button btnIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private CheckBox auto;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnReset;

    @FXML
    void autoComp(ActionEvent event) {
    	int  matricola =Integer.parseInt(txtMatricola.getText());
    	String st = model.cercaStudente(matricola);
    	if(st==null) {
    		txtArea.setText("studente non trovato");
    		txtMatricola.clear();
    	}
    	else {
    	txtArea.clear();
    	String[] studente=st.split(" ");
    	txtNome.setText(studente[0]);
    	txtCognome.setText(studente[1]);
    	}
    		
    	
    }

    @FXML
    void cercaCorsi(ActionEvent event) {
    	txtArea.clear();
    	String matricola = txtMatricola.getText();
    	String corsi =model.cercaCorsi(matricola);
    	txtArea.setText(corsi);
    }

    @FXML
    void cercaIscritti(ActionEvent event) {
    	txtArea.clear();
    	String corso = comboBox.getValue();
    	String iscritti=model.elencoIscritti(corso);
    	txtArea.setText(iscritti);

    }

    @FXML
    void iscrivi(ActionEvent event) {
    	int matricola =Integer.parseInt(txtMatricola.getText());
    	String nomeCorso = comboBox.getValue();
    	model.iscrivi(matricola,nomeCorso);

    }

    @FXML
    void reset(ActionEvent event) {
    	txtArea.clear();
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	auto.setSelected(false);
    }

    @FXML
    void initialize() {
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscritti != null : "fx:id=\"btnIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert auto != null : "fx:id=\"auto\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }


		
	}


