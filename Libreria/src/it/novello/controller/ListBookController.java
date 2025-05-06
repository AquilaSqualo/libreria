package it.novello.controller;

import java.util.ArrayList;
import java.util.List;

import it.novello.models.Libro;
import it.novello.service.LibroService;

public class ListBookController {
	private LibroService l_s = new LibroService();
	public List<Libro> elencaLibri() {
		return l_s.elencaLibri();
	}
	public List<Libro> elencaLibriPerAutore(int id_autore) {
		List<Libro> l_l = l_s.elencaLibri();
		List<Libro> l_la = new ArrayList<>();
		for (Libro book : l_l) {
			if(book.getAuthor().getId() == id_autore) l_la.add(book);
		}
		return l_la;
	}
}
