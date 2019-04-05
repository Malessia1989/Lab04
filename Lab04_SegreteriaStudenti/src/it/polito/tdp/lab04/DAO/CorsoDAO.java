package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				Corso c=new Corso(codins,numeroCrediti,nome,periodoDidattico);
				corsi.add(c);
			}

			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		// TODO
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		
		final String sql ="select s.matricola, s.cognome,s.nome,s.CDS\n" + 
				"from iscrizione as i, studente as s\n" + 
				"where i.matricola= s.matricola  and codIns =? ";
		List<Studente > studenti= new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getCodIns());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Studente s=new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"),rs.getString("cds"));
				studenti.add(s);
			}
			return studenti;
			
			}catch (SQLException e) {
				throw new RuntimeException("Errore DB");
			}	
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}
	


	public List < Corso> getCorsiAcuiIScrittiStudenti(int matricola) {
		final String sql="select c.codins,c.crediti,c.nome,c.pd " + 
				"from iscrizione as i, corso as c " + 
				"where c.codins=i.codins AND matricola=? ";
		
		List<Corso > corsi= new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Corso c= new Corso(rs.getString("codins"),rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				corsi.add(c);
			}
			return corsi;
			
			}catch (SQLException e) {
				throw new RuntimeException("Errore DB");
			}

		
		
	}
}
