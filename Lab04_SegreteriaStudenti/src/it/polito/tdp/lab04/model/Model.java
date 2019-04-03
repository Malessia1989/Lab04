package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Model {
	
	CorsoDAO corsoDAO =null;

	public Model() {
		
		this.corsoDAO = new CorsoDAO() ;
	}

	public List<Corso> getTuttiCorsi() {
		List<Corso> c= new LinkedList<Corso>(corsoDAO.getTuttiICorsi());
		return c;
	}
	
	
	

}
