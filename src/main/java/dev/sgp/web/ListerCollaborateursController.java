package dev.sgp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListerCollaborateursController
 */
public class ListerCollaborateursController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerCollaborateursController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().write("Hello ! ListerCollaborateursController");

		// recupere la valeur d'un parametre dont le nom est avecPhoto
		String avecPhotoParam = request.getParameter("avecPhoto");
		
		// recupere la valeur d'un parametre dont le nom est departement
		String departementParam = request.getParameter("departement");
		response.setContentType("text/html");
		
		// code HTML ecrit dans le corps de la reponse
		response.getWriter().write("<h1>Liste des collaborateurs</h1>" + "<ul>" + "<li>avecPhoto=" + avecPhotoParam
				+ "</li>" + "<li>departement=" + departementParam + "</li>" + "</ul>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
