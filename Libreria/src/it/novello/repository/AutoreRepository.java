package it.novello.repository;

import java.sql.Date;

public class AutoreRepository {
	public String aggiungiAutore(String nome,String cognome, Date compleanno) {
		return "INSERT INTO libreria.autori (nome,cognome,compleanno) values (\""+
				nome.toUpperCase()+"\",\""+cognome.toUpperCase()+"\",\""+compleanno+"\");";
	}
	public String aggiungiAutoreBreve(String nome,String cognome) {
		return "INSERT INTO libreria.autori (nome,cognome) values (\""+
				nome.toUpperCase()+"\",\""+cognome.toUpperCase()+"\");";
	}
	public String cercaAutoreNomeCognome(String nome,String cognome) {
		return "SELECT * FROM libreria.autori WHERE "
				+"nome = \""+nome.toUpperCase()
				+"\" AND cognome = \""+cognome.toUpperCase()+"\"";
	}
	public String cercaAutoreID(int id_autore) {
		return "SELECT * FROM libreria.autori WHERE id_autore = "+id_autore+"";
	}
	public String modificaAutore(int id_autore,String colonna,String variazione) {
		return "UPDATE libreria.autori SET "+colonna+" = \""+variazione+"\" where id_autore = "+id_autore;
	}
	public String listaAutori() {
		return "SELECT * FROM libreria.autori ORDER BY cognome,nome";
	}
	public String eliminaAutore(int id_autore) {
		return "DELETE FROM libreria.autori WHERE id_autore="+id_autore;
	}
}
