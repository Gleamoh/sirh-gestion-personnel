package dev.sgp.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditerCollaborateurController
 */
public class EditerCollaborateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditerCollaborateurController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String matricule = request.getParameter("matricule");
		if (null == matricule) {
			response.sendError(400, "Un matricule est attendu");
		} else {
			// code HTML ecrit dans le corps de la reponse
			response.setStatus(201);
			response.getWriter().write("<h1>Edition de collaborateur</h1>" + "Matricule: " + matricule);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String matricule = request.getParameter("matricule");
		String titre = request.getParameter("titre");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		Map<String, String> params = new HashMap<>();

		params.put("matricule", matricule);
		params.put("titre", titre);
		params.put("nom", nom);
		params.put("prenom", prenom);

		String message = "Les paramètres suivants sont incorrects: ";

		for (Map.Entry<String, String> p : params.entrySet()) {
			if (null == p.getValue() || p.getValue().equals("")) {
				message += p.getKey() + ", ";
			}
		}

		System.out.println(message);
		
		if (false == message.equals("Les paramètres suivants sont incorrects: ")) {
			response.sendError(400, message);
		} else {
			message = "Creation d’un collaborateur avec les informations suivantes :" + "matricule=" + matricule
					+ ",titre=" + titre + ",nom=" + nom + ",prenom=" + prenom;
			response.setStatus(201);
			response.getWriter().write(message);
		}
	}
}
