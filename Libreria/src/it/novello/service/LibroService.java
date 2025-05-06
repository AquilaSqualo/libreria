package it.novello.service;

import java.util.List;

import it.novello.dbconnection.DBEdit;
import it.novello.dbconnection.DBRead;
import it.novello.models.Libro;

public class LibroService {
	private DBRead dbread = new DBRead();
	private DBEdit dbedit = new DBEdit(); 
	public Libro trovaLibroTitoloSottotitolo(String titolo,String sottotitolo) {
		return dbread.trovaLibroTitoloSottotitolo(titolo,sottotitolo);
	}
	public Libro trovaLibroID(int id_libro) {
		return dbread.trovaLibroID(id_libro);
	}
	public void creaLibro(Libro libro) {
		dbedit.inserisciLibro(libro.getTitle(), libro.getSubTitle(), libro.getAuthor().getNome(), libro.getAuthor().getCognome(), libro.getEditor(), libro.getYear(), libro.getPages());
	}
	public void segnaPagina(int segnalibro,Libro libro) {
		dbedit.segnaPagina(segnalibro, libro.getId());
	}
	public void modificaLibro(Libro book,String column,String value) {
		dbedit.modificaLibro(book.getId(), column, value);
	}
	public List<Libro> elencaLibri() {
		return dbread.elencaLibri();
	}
	public void elimina(int id_libro) {
		dbedit.eliminaLibro(id_libro);
	}
}
