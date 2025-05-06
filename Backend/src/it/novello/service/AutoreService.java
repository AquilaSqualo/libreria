package it.novello.service;

import java.util.List;

import it.novello.dbconnection.DBEdit;
import it.novello.dbconnection.DBRead;
import it.novello.models.Autore;

public class AutoreService {
	private DBEdit dbedit = new DBEdit();
	private DBRead dbread = new DBRead();
	
	public Autore creaAutore(Autore autore) {
		if(dbread.trovaAutoreNomeCognome(autore.getNome(), autore.getCognome()).getNome() == null) {
			System.out.println("Autore "+autore.getNome()+" "+autore.getCognome()+" non esiste");
			dbedit.inserisciAutore(autore.getNome(), autore.getCognome(), autore.getCompleanno());
		} else {
			System.out.println("Autore "+autore.getNome()+" "+autore.getCognome()+" esiste");
		}
		return dbread.trovaAutoreNomeCognome(autore.getNome(), autore.getCognome());
	}
	
	public Autore trovaAutoreNomeCognome(String nome,String cognome) {
		dbread.trovaAutoreNomeCognome(nome, cognome);
		return dbread.trovaAutoreNomeCognome(nome, cognome);
	}
	public Autore trovaAutoreID(int id_autore) {
		return dbread.trovaAutoreID(id_autore);
	}
	
	public Autore modificaAutore(int id_autore,String colonna,String variazione) {
		dbedit.modificaAutore(id_autore, colonna, variazione);
		return trovaAutoreID(id_autore);
	}

	public List<Autore> elencaAutori() {
		return dbread.elencaAutori();
	}

	public void eliminaPerId(int id_autore) {
		dbedit.eliminaAutore(id_autore);
	}
}
