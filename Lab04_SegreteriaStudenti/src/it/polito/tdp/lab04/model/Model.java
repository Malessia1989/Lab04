package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	private CorsoDAO corsoDAO=null;
	private StudenteDAO studenteDAO=null;
	private List<Studente> studenti;
	
	
	public Model() {
	
		this.corsoDAO =new CorsoDAO();
		this.studenteDAO=new StudenteDAO();
		this.studenti=new LinkedList<Studente>();
		
	}

	public List<Corso> getTuttiCorsi() {
		List<Corso> ris=corsoDAO.getTuttiICorsi(); 
		return  ris;
	}

//	public boolean isDigit(String matricola) {
//
//		return matricola.matches("\\+d");
//	}
	
	public List<Studente> getTuttiStudenti() {
		List<Studente> st=studenteDAO.getTuttiStudenti(); 
		return  st;
	}

//	public String getNome(int matricola) {
//		for(Studente s : studenteDAO.getTuttiStudenti()) {
//			if(s.getMatricola()==matricola) {
//				return s.getNome();
//		}
//		
//	}
//		return null;
//	}
//
//	public String getCognome(int matricola) {
//		studenti=studenteDAO.getTuttiStudenti();
//			for(Studente s: studenti) {
//				if(s.getMatricola()== matricola)
//					return s.getCognome();
//			}
//			return null;
//	}

	public List<Studente> getStudentiIscrittiAlCorso(Corso c) {
		List<Studente> iscritti=corsoDAO.getStudentiIscrittiAlCorso(c);
		List<Studente> risultato=new LinkedList<Studente>();
	
		for(Studente s:studenteDAO.getTuttiStudenti()) {
			for (Studente st:iscritti){
				if(s.getMatricola()==st.getMatricola()) {
					risultato.add(s);
				}
			}		
		}
		
		return risultato;
	}

	public List<Corso> getCorsiDegliStudenti(Studente s) {
		List<Corso> iscritti =corsoDAO.getCorsiAcuiIScrittiStudenti(s);
		List<Corso> tuttiCorsi=corsoDAO.getTuttiICorsi();
		List<Corso> ris= new LinkedList<Corso>();
		
		for(Corso c: tuttiCorsi) {
				for(Corso cs:iscritti) {
					if(c.getCodIns().compareTo(cs.getCodIns())==0) {
						ris.add(c);
					}
				}
		}
		return ris;
			}

	}
