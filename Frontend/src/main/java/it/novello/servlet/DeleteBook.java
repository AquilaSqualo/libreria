package it.novello.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.novello.controller.LibroController;
import it.novello.models.Libro;

/**
 * Servlet implementation class DeleteBook
 */
@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroController l_c = new LibroController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getQueryString();
		Libro book = l_c.cercaLibroID(Integer.parseInt(url.substring(url.indexOf("id=")+3)));
		request.getSession().setAttribute("book", book);
		request.getRequestDispatcher("delete-book.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getQueryString();
		l_c.elimina(Integer.parseInt(url.substring(url.indexOf("id=")+3)));
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
