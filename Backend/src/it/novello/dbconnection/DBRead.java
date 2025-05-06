package it.novello.dbconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.novello.models.Autore;
import it.novello.models.Libro;
import it.novello.repository.AutoreRepository;
import it.novello.repository.LibroRepository;

public class DBRead {
	private AutoreRepository aRep = new AutoreRepository();
	private LibroRepository lRep = new LibroRepository();
	
	public Autore trovaAutoreNomeCognome(String nome,String cognome) {
		Autore autore = new Autore();
		try {
			Connection conn = DBConnection.startMySQLConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(aRep.cercaAutoreNomeCognome(nome, cognome));
			while(rs.next()) {
				autore.setId(rs.getInt("id_autore"));
				autore.setNome(rs.getString("nome"));
				autore.setCognome(rs.getString("cognome"));
				autore.setCompleanno(rs.getDate("compleanno"));
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return autore;
	}
	
	public Autore trovaAutoreID(int id_autore) {
		Autore autore = new Autore();
		try {
			Connection conn = DBConnection.startMySQLConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(aRep.cercaAutoreID(id_autore));
			while(rs.next()) {
				autore.setId(rs.getInt("id_autore"));
				autore.setNome(rs.getString("nome"));
				autore.setCognome(rs.getString("cognome"));
				autore.setCompleanno(rs.getDate("compleanno"));
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return autore;
	}
	
	public Libro trovaLibroTitoloSottotitolo(String titolo,String sottotitolo) {
		Libro libro = new Libro();
		try {
			Connection conn = DBConnection.startMySQLConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(lRep.cercaLibroTitoloSottotitolo(titolo,sottotitolo));
			while(rs.next()) {
				libro.setId(rs.getInt("id_libro"));
				libro.setTitle(rs.getString("titolo"));
				libro.setSubTitle(rs.getString("sottoTitolo"));
				libro.setAuthor(
						trovaAutoreID(rs.getInt("id_autore"))
						);
				libro.setEditor(rs.getString("editore"));
				libro.setYear(rs.getInt("anno"));
				libro.setPages(rs.getInt("pagine"));
				libro.setBookmark(rs.getInt("segnalibro"));
				System.out.println(libro.getId()+" "+libro.getTitle()+" "+libro.getSubTitle()+" "+
						libro.getAuthor().getNome()+libro.getAuthor().getCognome()+
						" "+libro.getEditor()+" "+libro.getYear()+" "+libro.getPages()+" "+libro.getBookmark());
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libro;
	}
	public Libro trovaLibroID(int id) {
		Libro libro = new Libro();
		try {
			Connection conn = DBConnection.startMySQLConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(lRep.cercaLibroID(id));
			while(rs.next()) {
				libro.setId(rs.getInt("id_libro"));
				libro.setTitle(rs.getString("titolo"));
				libro.setSubTitle(rs.getString("sottoTitolo"));
				libro.setAuthor(
						trovaAutoreID(rs.getInt("id_autore"))
						);
				libro.setEditor(rs.getString("editore"));
				libro.setYear(rs.getInt("anno"));
				libro.setPages(rs.getInt("pagine"));
				libro.setBookmark(rs.getInt("segnalibro"));
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libro;
	}
	public List<Libro> elencaLibri() {
		List<Libro> l_l = new ArrayList<>();
		try {
			Connection conn = DBConnection.startMySQLConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(lRep.listaLibri());
			while(rs.next()) {
				Libro libro = new Libro();
				libro.setId(rs.getInt("id_libro"));
				libro.setTitle(rs.getString("titolo"));
				libro.setSubTitle(rs.getString("sottoTitolo"));
				libro.setAuthor(
						trovaAutoreID(rs.getInt("id_autore"))
						);
				libro.setEditor(rs.getString("editore"));
				libro.setYear(rs.getInt("anno"));
				libro.setPages(rs.getInt("pagine"));
				libro.setBookmark(rs.getInt("segnalibro"));
				l_l.add(libro);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l_l;
	}

	public List<Autore> elencaAutori() {
		List<Autore> l_a = new ArrayList<>();
		try {
			Connection conn = DBConnection.startMySQLConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(aRep.listaAutori());
			while(rs.next()) {
				Autore author = new Autore();
				author.setId(rs.getInt("id_autore"));
				author.setNome(rs.getString("nome"));
				author.setCognome(rs.getString("cognome"));
				author.setCompleanno(rs.getDate("compleanno"));
				l_a.add(author);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l_a;
	}

	public int contaLibriPerAutore(int id_autore) {
		int contatore = 0;
		for (Libro book : elencaLibri()) {
			if(book.getAuthor().getId() == id_autore) contatore++;
		}
		return contatore;
	}
}
