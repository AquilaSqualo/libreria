package it.novello.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.novello.controller.AutoreController;
import it.novello.models.Autore;

/**
 * Servlet implementation class EditAuthor
 */
@WebServlet("/EditAuthor")
public class EditAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AutoreController a_c = new AutoreController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getQueryString();
		Autore author = a_c.cercaPerID(Integer.parseInt(url.substring(url.indexOf("id=") + 3)));
		request.getSession().setAttribute("author", author);
		request.getRequestDispatcher("edit-author.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getQueryString();
		Autore author = a_c.cercaPerID(Integer.parseInt(url.substring(url.indexOf("id=") + 3)));
		String nome = request.getParameter("Nome");
		String cognome = request.getParameter("Cognome");
		String compleanno = request.getParameter("Compleanno");
		a_c.modificaAutore(author, "nome", nome);
		a_c.modificaAutore(author, "Cognome", cognome);
		if (compleanno != "") a_c.modificaAutore(author, "Compleanno", compleanno);
		request.getRequestDispatcher("/AllAuthors").forward(request, response);
	}

}
