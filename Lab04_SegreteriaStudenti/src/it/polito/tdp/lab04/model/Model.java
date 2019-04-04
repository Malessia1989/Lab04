package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	
	public Model() {
	
		
	}
	public boolean isDigit(String matricola) {
		
		return matricola.matches( "\\d{6}");
	}



	public Studente getStudenteByID(String matricola) {
		StudenteDAO dao= new StudenteDAO();
		return dao.getStudenteByID(Integer.parseInt(matricola));
	}



	public String getElencoCorsi(String matricola) {
		CorsoDAO dao= new CorsoDAO();
		List<Corso> corsiSeguiti= new LinkedList<Corso>(dao.getCorsiAcuiIScrittiStudenti(Integer.parseInt(matricola)));
		String elencoCorsi="";
		for(Corso c:corsiSeguiti) {
			elencoCorsi+=corsiSeguiti.toString() + "\n";
		}
		return elencoCorsi;
	}



	public String getElencoStudenti(Corso corsoSelezionato) {
		CorsoDAO dao= new CorsoDAO();
		List<Studente> studenti = new LinkedList<Studente>(dao.getStudentiIscrittiAlCorso(corsoSelezionato));
		String elencoStudenti="";
		for(Studente st: studenti) {
			elencoStudenti+=studenti.toString() +"\n";
		}
		return elencoStudenti;
	}



	public static List<Corso> getAllCorsi() {
		CorsoDAO dao= new CorsoDAO();
		List<Corso> corsi = new LinkedList<Corso>(dao.getTuttiICorsi());
		return corsi;
	}

	}
