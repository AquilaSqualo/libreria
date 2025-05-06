package it.novello.business;

//import java.sql.Date;

//import it.novello.controller.DateConversion;

//import it.novello.controller.AutoreController;
//import it.novello.controller.DateConversion;
//import it.novello.controller.LibroController;
import it.novello.controller.ListBookController;
//import it.novello.models.Autore;
import it.novello.models.Libro;

public class Libreria {

	public static void main(String[] args) {
//		LibroController l_c = new LibroController();
//		Libro book = new Libro();
		ListBookController lb_c = new ListBookController();
//		book = l_c.cercaLibroTitolo("Sigma");
//		if(book.getTitle() != null) l_c.segnaPagina(book, 3);
//		else System.out.println("Errore");
//		AutoreController a_c = new AutoreController();
//		Autore autore = new Autore();
//		DateConversion dc = new DateConversion();
//		
//		autore = a_c.cercaPerID(2);
//		System.out.println(autore.getCompleanno()+"; "+dc.fromStringToDate("19/05/1992"));
//		for(int i = 0;i<lb_c.elencaLibri().size();i++) {
//			l_c.stampaSuLinea(lb_c.elencaLibri().get(i));
//		}
//		String input = "01/01/2025";
//		DateConversion dc = new DateConversion();
//		Date cal = dc.fromStringToDate(input);
//		System.out.println(cal);
//		
//		System.out.println(dc.fromDateToString(cal));
		int id = 10;
		if(lb_c.elencaLibriPerAutore(id).isEmpty()) System.out.println("Nessun libro trovato");
		else for(Libro book : lb_c.elencaLibriPerAutore(id)) System.out.println(book.getTitle());
	}

}
