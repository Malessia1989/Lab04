package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public List<Studente> getTuttiStudenti() {
		
		final String sql= "SELECT * FROM studente";
		
		List<Studente> studenti = new LinkedList<Studente>();
		
		try {
			Connection conn =ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				int matricola =rs.getInt("matricola");
				String cognome= rs.getString("cognome");
				String nome= rs.getString("nome");
				String cds= rs.getString("cds");
				
			//	System.out.println(matricola + " " + cognome + " " + nome + " " + cds);

				
				Studente s=new Studente(matricola, cognome, nome, cds);
				studenti.add(s);
				
			}
		
		return studenti;
	
		}catch (SQLException e) {
			throw new RuntimeException("Errore DB");
		}
	}

	public Studente getStudenteByID(int matricola) {
		
		final String sql=" select nome, cognome " + 
				"from studente " + 
				"where matricola= ? ";
		
		Studente s=null;
		
		try {
			Connection conn =ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			
			ResultSet rs = st.executeQuery();
			
			
			
			while(rs.next()) {
				
				String nome= rs.getString("nome");
				String cognome= rs.getString("cognome");
				s= new Studente (nome,cognome);
				
			}
						return  s;

		}catch (Exception e) {
			throw new RuntimeException("Errore DB");
		}
	
}
}

