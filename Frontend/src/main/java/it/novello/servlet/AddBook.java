package it.novello.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import it.novello.controller.AutoreController;
import it.novello.controller.LibroController;
import it.novello.controller.ListAuthorController;
import it.novello.models.Autore;

/**
 * Servlet implementation class AddBook
 */
@WebServlet(name="AddBookServlet", urlPatterns="/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroController l_c = new LibroController();
	private AutoreController a_c = new AutoreController();
	private ListAuthorController la_c = new ListAuthorController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Autore> listAuthors = la_c.elencaAutori();
		request.getSession().setAttribute("authors", listAuthors);
		request.getRequestDispatcher("create-book.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("Titolo");
		String subtitle = request.getParameter("Sottotitolo");
		String author_n = request.getParameter("Autore");
		String editor = request.getParameter("Editore");
		String year_s = request.getParameter("Anno");
		String pages_s = request.getParameter("Pagine");
		Autore author = a_c.cercaPerID(Integer.parseInt(author_n));
		int year;
		int pages;
		if(year_s == null || year_s == "") year = 0;
		else year = Integer.parseInt(year_s);
		if(pages_s == null || pages_s == "") pages = 0;
		else pages = Integer.parseInt(pages_s);
		if(l_c.cercaLibroTitoloSottotitolo(title,subtitle).getTitle() == null) {
			if(l_c.creaLibro(title, subtitle, author.getNome(), author.getCognome(), editor, year, pages).getTitle() != null)
				request.getRequestDispatcher("index.jsp").forward(request, response);
		} else request.getRequestDispatcher("create-book.jsp").forward(request, response);
		
	}

}
