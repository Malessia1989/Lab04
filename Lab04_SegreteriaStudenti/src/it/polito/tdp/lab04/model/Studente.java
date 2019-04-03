package it.polito.tdp.lab04.model;

public class Studente {
	
	private int matricola;
	private String cognome;
	private String nome;
	private int pd;
	
	public Studente(int matricola, String cognome, String nome, int pd) {
		super();
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.pd = pd;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPd() {
		return pd;
	}
	public void setPd(int pd) {
		this.pd = pd;
	}
	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", cognome=" + cognome + ", nome=" + nome + ", pd=" + pd + "]";
	} 
	
	
}
