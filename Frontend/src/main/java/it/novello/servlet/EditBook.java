package it.novello.servlet;

import java.io.IOException;
import java.util.List;

import it.novello.controller.LibroController;
import it.novello.controller.ListAuthorController;
import it.novello.models.Autore;
import it.novello.models.Libro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditBook
 */
@WebServlet("/EditBook")
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroController l_c = new LibroController();
	private ListAuthorController la_c = new ListAuthorController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getQueryString();
		Libro book = l_c.cercaLibroID(Integer.parseInt(url.substring(url.indexOf("id=")+3)));
		List<Autore> listAuthors = la_c.elencaAutori();
		request.getSession().setAttribute("book", book);
		request.getSession().setAttribute("authors", listAuthors);
		request.getRequestDispatcher("edit-book.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getQueryString();
		Libro book = l_c.cercaLibroID(Integer.parseInt(url.substring(url.indexOf("id=")+3)));
		String title = request.getParameter("Titolo");
		String subtitle = request.getParameter("Sottotitolo");
		String author_id = request.getParameter("Autore");
		String editor = request.getParameter("Editore");
		String year = request.getParameter("Anno");
		String pages = request.getParameter("Pagine");
		String bookmark = request.getParameter("Segnalibro");
		l_c.modificaLibro(book, "Titolo", title);
		l_c.modificaLibro(book, "Sottotitolo", subtitle);
		l_c.modificaLibro(book, "Id_autore", author_id);
		l_c.modificaLibro(book, "Editore", editor);
		l_c.modificaLibro(book, "Anno", year);
		l_c.modificaLibro(book, "Pagine", pages);
		l_c.modificaLibro(book, "Segnalibro", bookmark);
		request.getRequestDispatcher("/BookDetails?id="+book.getId()).forward(request, response);
	}

}
