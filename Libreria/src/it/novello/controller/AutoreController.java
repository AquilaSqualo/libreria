package it.novello.controller;

import it.novello.models.Autore;
import it.novello.service.AutoreService;

public class AutoreController {
	private Autore autore = new Autore();
	private AutoreService autoreS = new AutoreService();
	private DateConversion dc = new DateConversion();
	public Autore creaAutore(String nome,String cognome,String compleanno) {
		autore.setNome(nome);
		autore.setCognome(cognome);
		autore.setCompleanno(dc.fromStringToDate(compleanno));
		autore = autoreS.creaAutore(autore);
		return autore;
	}
	public Autore creaAutoreBreve(String nome,String cognome) {
		autore.setNome(nome);
		autore.setCognome(cognome);
		autoreS.creaAutore(autore);
		return autore;
	}
	public Autore cercaPerID(int id) {
		autore = autoreS.trovaAutoreID(id);
		return autore;
	}
	public Autore cercaPerNome(String nome,String cognome) {
		autore = autoreS.trovaAutoreNomeCognome(nome,cognome);
		return autore;
	}
	public Autore modificaAutore(Autore author,String column,String value) {
		int id_autore = cercaPerNome(author.getNome(), author.getCognome()).getId();
		autoreS.modificaAutore(id_autore, column, value);
		return cercaPerID(id_autore);
	}
	public void eliminaPerId(int id_autore) {
		autoreS.eliminaPerId(id_autore);
	}
}
