package it.novello.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.novello.controller.ListBookController;
import it.novello.models.Libro;

/**
 * Servlet implementation class AllBooks
 */
@WebServlet("/AllBooks")
public class AllBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Libro> allBooks = new ArrayList<>();
	private ListBookController lb_c = new ListBookController();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		allBooks = lb_c.elencaLibri();
		request.getSession().setAttribute("listBook", (List<Libro>) allBooks);
		request.getRequestDispatcher("biblioteca.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
