package it.novello.controller;

import it.novello.models.Autore;
import it.novello.models.Libro;
import it.novello.service.LibroService;

public class LibroController {
	private Libro libro = new Libro();
	private Autore autore = new Autore();
	private AutoreController a_c = new AutoreController();
	private LibroService l_s = new LibroService();
	public Libro creaLibro(String titolo,String sottoTitolo,String nome_autore,String cognome_autore,String editore, int anno,int pagine) {
		libro = cercaLibroTitoloSottotitolo(titolo,sottoTitolo);
		// Se il libro esite, ritorna il libro esistente
		if (libro.getTitle() != null && libro.getSubTitle() == sottoTitolo.toUpperCase()) return libro;
		libro.setTitle(titolo);
		libro.setSubTitle(sottoTitolo);
		autore = a_c.cercaPerNome(nome_autore, cognome_autore);
		if(autore == null) autore = a_c.creaAutoreBreve(nome_autore,cognome_autore);
		libro.setAuthor(autore);
		libro.setEditor(editore);
		libro.setYear(anno);
		libro.setPages(pagine);
		libro.setBookmark(0);
		l_s.creaLibro(libro);
		return libro;
	}
	public Libro creaLibro(String titolo,String sottoTitolo,String nome_autore,String cognome_autore,String editore) {
		libro = cercaLibroTitoloSottotitolo(titolo,sottoTitolo);
		// Se il libro esite, ritorna il libro esistente
		if (libro.getTitle() != null && libro.getSubTitle() == sottoTitolo.toUpperCase()) return libro;
		libro.setTitle(titolo);
		libro.setSubTitle(sottoTitolo);
		if(a_c.cercaPerNome(nome_autore, cognome_autore) == null)
			autore = a_c.creaAutoreBreve(nome_autore,nome_autore);
		libro.setAuthor(autore);
		libro.setEditor(editore);
		libro.setYear(0);
		libro.setPages(0);
		libro.setBookmark(0);
		l_s.creaLibro(libro);
		return libro;
	}
	public Libro creaLibro(String titolo,String nome_autore,String cognome_autore,String editore) {
		libro = cercaLibroTitolo(titolo);
		// Se il libro esite, ritorna il libro esistente
		if (libro.getTitle() != null) return libro;
		libro.setTitle(titolo);
		if(a_c.cercaPerNome(nome_autore, cognome_autore) == null)
			autore = a_c.creaAutoreBreve(nome_autore,nome_autore);
		libro.setAuthor(autore);
		libro.setEditor(editore);
		libro.setYear(0);
		libro.setPages(0);
		libro.setBookmark(0);
		return libro;
	}
	public Libro creaLibro(String titolo,String nome_autore,String cognome_autore) {
		libro = cercaLibroTitolo(titolo);
		// Se il libro esite, ritorna il libro esistente
		if (libro.getTitle() != null) return libro;
		libro.setTitle(titolo);
		if(a_c.cercaPerNome(nome_autore, cognome_autore) == null)
			autore = a_c.creaAutoreBreve(nome_autore,nome_autore);
		libro.setAuthor(autore);
		libro.setYear(0);
		libro.setPages(0);
		libro.setBookmark(0);
		return libro;
	}
	public void stampaSuLinea(Libro book) {
		System.out.println("Titolo: "+capitalize(book.getTitle())+", Sottotitolo: "+capitalize(book.getSubTitle())+
				", Autore: "+capitalize(book.getAuthor().getNome())+" "+capitalize(book.getAuthor().getCognome())+
				", Editore: "+capitalize(book.getEditor())+", Anno: "+book.getYear()+", Pagine: "+book.getPages()+", Segnalibro: "+book.getBookmark());
	}
	public String capitalize(String input) {
		if(input == null || input == "" || input.length() < 1) return input;
		else return input.substring(0, 1).toUpperCase()+input.substring(1).toLowerCase();
	}
	public boolean letto(Libro book) {
		boolean stato = false;
		if(book.getBookmark()==book.getPages())
			stato = true;
		return stato;
	}
	public int segnaPagina(Libro book, int mark) {
		try {
			if(mark<0)
				throw new Exception("Il valore del segnalibro è negativo!");
			else if(!(book.getPages() > 0))
				throw new Exception("Numero pagine non impostato");
			else if(mark>book.getPages())
				throw new Exception("Il valore del segnalibro è superiore al numero di pagine del libro.");
			else {
				l_s.segnaPagina(mark, book);
				System.out.println("Pagina segnata");
				return mark;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return book.getBookmark();
	}
	public void segnaComeLetto(Libro book) {
		book.setBookmark(book.getPages());
		l_s.segnaPagina(book.getPages(), book);
	}
	public Libro cercaLibroTitolo(String titolo) {
		return l_s.trovaLibroTitoloSottotitolo(titolo,null);
	}
	public Libro cercaLibroTitoloSottotitolo(String titolo,String sottotitolo) {
		return l_s.trovaLibroTitoloSottotitolo(titolo,sottotitolo);
	}
	public Libro cercaLibroID(int id_libro) {
		return l_s.trovaLibroID(id_libro);
	}
	
	public Libro modificaLibro(Libro book,String column,String value) {
		int id_libro = book.getId();
		l_s.modificaLibro(l_s.trovaLibroID(id_libro), column, value.toUpperCase());
		return l_s.trovaLibroID(id_libro);
	}
	public void elimina(int id_libro) {
		l_s.elimina(id_libro);
	}
}
