package it.novello.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.novello.controller.ListAuthorController;
import it.novello.models.Autore;

/**
 * Servlet implementation class AllAuthors
 */
@WebServlet("/AllAuthors")
public class AllAuthors extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Autore> allAuthors = new ArrayList<>();
	private ListAuthorController la_c = new ListAuthorController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		allAuthors = la_c.elencaAutori();
		request.getSession().setAttribute("authors", allAuthors);
		request.getRequestDispatcher("autori.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
