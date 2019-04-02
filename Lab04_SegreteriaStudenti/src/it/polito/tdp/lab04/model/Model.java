package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	CorsoDAO cdao = new CorsoDAO();
	StudenteDAO sdao = new StudenteDAO();
	Studente s;
	String[] sx;
	
	public ObservableList<String> getComboBox(){
		List<String> nomiCorsi = new ArrayList<String>();
		
		for(Corso c :cdao.getTuttiICorsi()) {
			String temp =c.getNome();
			nomiCorsi.add(temp);
		}
		
		ObservableList<String> l = FXCollections.observableList(nomiCorsi);
		l.add("");
		return l;
	}
	
	public String cercaStudente(int matricola){
		String cercato = null;
		for(Studente temp : sdao.getElencoStudenti()) {
			if(temp.getMatricola()==matricola) {
				cercato=temp.getNome()+" "+temp.getCognome()+" "+temp.getCDS();
			}
		}
		return cercato;	
	}
	
	public String elencoIscritti(String nomeCorso) {
		String iscritti = "";
		for(Studente temp : sdao.getElencoIscritti(nomeCorso)) {
			iscritti += temp.getMatricola()+" "+temp.getNome()+" "+temp.getCognome()+"\n";
		}
		return iscritti;
	}
	
	public String cercaCorsi(String matricola) {
		String corsi="";
		for(Corso temp : sdao.getElencoCorsi(matricola)) {
			corsi += temp.getNome()+"\n";
		}
		return corsi;
	}
	
	public void iscrivi(int matricola,String nomeCorso) {
	
		sdao.iscrivi(matricola,nomeCorso);
	}

}

