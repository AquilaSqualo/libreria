package it.novello.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.novello.controller.AutoreController;
import it.novello.controller.ListBookController;
import it.novello.models.Autore;

/**
 * Servlet implementation class DeleteAuthor
 */
@WebServlet("/DeleteAuthor")
public class DeleteAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AutoreController a_c = new AutoreController();
	private ListBookController lb_c = new ListBookController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getQueryString();
		Autore author = a_c.cercaPerID(Integer.parseInt(url.substring(url.indexOf("id=") + 3)));
		request.getSession().setAttribute("author", author);
		if(lb_c.elencaLibriPerAutore(author.getId()).isEmpty())
			request.getRequestDispatcher("delete-author.jsp").forward(request, response);
		else request.getRequestDispatcher("not-deletable-author.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getQueryString();
		a_c.eliminaPerId(Integer.parseInt(url.substring(url.indexOf("id=") + 3)));
		request.getRequestDispatcher("/AllAuthors").forward(request, response);
	}

}
