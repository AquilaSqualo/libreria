package it.novello.models;

import java.sql.Date;

public class Autore {
	private int id;
	private String nome;
	private String cognome;
	private Date compleanno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getCompleanno() {
		return compleanno;
	}
	public void setCompleanno(Date compleanno) {
		this.compleanno = compleanno;
	}
	
}
