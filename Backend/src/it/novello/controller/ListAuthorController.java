package it.novello.controller;

import java.util.List;

import it.novello.models.Autore;
import it.novello.service.AutoreService;

public class ListAuthorController {
	private AutoreService a_s = new AutoreService();
	public List<Autore> elencaAutori() {
		return a_s.elencaAutori();
	}
}
