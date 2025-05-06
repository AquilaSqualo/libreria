package it.novello.repository;

public class LibroRepository {
	public String aggiungiLibro(String titolo,String sottoTitolo,String nome_autore,String cognome_autore, String editore, int anno, int pagine) {
		return "INSERT INTO libreria.libri (titolo,sottoTitolo,id_autore,editore,anno,pagine) values (\""+
				titolo.toUpperCase()+"\",\""+sottoTitolo.toUpperCase()+"\","+
				"(SELECT id_autore FROM libreria.autori WHERE "
				+ "nome = \""+nome_autore.toUpperCase()+"\" AND cognome = \""+cognome_autore.toUpperCase()+"\"),\""
				+editore.toUpperCase()+"\","+anno+","+pagine+");";
	}
	public String cercaLibroTitoloSottotitolo(String titolo,String sottotitolo) {
		if(sottotitolo == null) return "SELECT * FROM libreria.libri WHERE titolo = \""+titolo.toUpperCase()+"\"";
		return "SELECT * FROM libreria.libri WHERE titolo = \""+titolo.toUpperCase()+"\" AND sottotitolo = \""+sottotitolo.toUpperCase()+"\"";
	}
	public String cercaLibroID(int id_libro) {
		return "SELECT * FROM libreria.libri WHERE id_libro = "+id_libro+"";
	}
	public String contaLibriPerAutore(int id_autore) {
		return "SELECT COUNT(id_libro) FROM libreria.libri WHERE id_autore = "+id_autore;
	}
	public String segnaPagina(int segnalibro,int id_libro) {
		return "UPDATE libreria.libri SET segnalibro = "+segnalibro+" where id_libro = "+id_libro;
	}
	public String modificaLibro(int id_libro,String colonna,String variazione) {
		return "UPDATE libreria.libri SET "+colonna+" = \""+variazione+"\" where id_libro = "+id_libro;
	}
	public String listaLibri() {
		return "SELECT * FROM libreria.libri ORDER BY titolo,anno,sottotitolo";
	}
	public String eliminaLibro(int id_libro) {
		return "DELETE FROM libreria.libri WHERE id_libro = "+id_libro;
	}
}
