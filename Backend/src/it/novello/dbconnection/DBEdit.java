package it.novello.dbconnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.novello.repository.AutoreRepository;
import it.novello.repository.LibroRepository;

public class DBEdit {
	private AutoreRepository aRep = new AutoreRepository();
	private LibroRepository lRep = new LibroRepository();
	private DBRead dbread = new DBRead();
	
	public void inserisciLibro(String titolo,String sottoTitolo,String nome_autore,String cognome_autore,
			String editore,int anno,int pagine) {
		try {
			Connection conn = DBConnection.startMySQLConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(aRep.cercaAutoreNomeCognome(nome_autore, cognome_autore));
			if(!rs.next()) {
				throw new SQLException("Autore non trovato");
			} else {
				stmt.executeUpdate(lRep.aggiungiLibro(titolo,sottoTitolo, nome_autore, cognome_autore, editore, anno, pagine));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inserisciAutore(String nome,String cognome,Date compleanno) {
		try {
			Connection conn = DBConnection.startMySQLConnection();
			Statement stmt = conn.createStatement();
			if(compleanno == null)
				stmt.executeUpdate(aRep.aggiungiAutoreBreve(nome, cognome));
			else stmt.executeUpdate(aRep.aggiungiAutore(nome, cognome, compleanno));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void segnaPagina(int segnalibro,int id_libro) {
		try {
			Connection conn = DBConnection.startMySQLConnection();
			Statement stmt = conn.createStatement();
			if(!(segnalibro >0))
				throw new Exception("Valore segnalibro non valido");
			else stmt.executeUpdate(lRep.segnaPagina(segnalibro, id_libro));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modificaLibro(int id_libro,String colonna,String variazione) {
		try {
			Connection conn = DBConnection.startMySQLConnection();
			Statement stmt = conn.createStatement();
			if(lRep.cercaLibroID(id_libro) == null)
				throw new Exception("Libro non trovato");
			else stmt.executeUpdate(lRep.modificaLibro(id_libro, colonna, variazione));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modificaAutore(int id_autore,String colonna,String variazione) {
		try {
			Connection conn = DBConnection.startMySQLConnection();
			Statement stmt = conn.createStatement();
			if(aRep.cercaAutoreID(id_autore) == null)
				throw new Exception("Autore non trovato");
			else stmt.executeUpdate(aRep.modificaAutore(id_autore, colonna, variazione));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminaLibro(int id_libro) {
		try {
			Connection conn = DBConnection.startMySQLConnection();
			Statement stmt = conn.createStatement();
			if(lRep.cercaLibroID(id_libro) == null)
				throw new Exception("Libro non trovato");
			else stmt.executeUpdate(lRep.eliminaLibro(id_libro));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminaAutore(int id_autore) {
		try {
			Connection conn = DBConnection.startMySQLConnection();
			Statement stmt = conn.createStatement();
			if(dbread.trovaAutoreID(id_autore) == null) throw new Exception("Autore non trovato");
			else if(dbread.contaLibriPerAutore(id_autore) > 0) throw new Exception("Autore non cancellabile");
			else stmt.executeUpdate(aRep.eliminaAutore(id_autore));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
