package it.novello.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.novello.controller.AutoreController;

/**
 * Servlet implementation class AddAuthor
 */
@WebServlet("/AddAuthor")
public class AddAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AutoreController a_c = new AutoreController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("create-author.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Nome");
		String surname = request.getParameter("Cognome");
		String birthday = request.getParameter("Compleanno");
		
		if(a_c.cercaPerNome(name, surname).getNome() == null) {
			if(birthday == null || birthday == "") {
				a_c.creaAutoreBreve(name, surname);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else {
				a_c.creaAutore(name, surname, birthday);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else request.getRequestDispatcher("create-author.jsp").forward(request, response);
	}

}
