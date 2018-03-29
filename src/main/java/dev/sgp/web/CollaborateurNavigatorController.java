package dev.sgp.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.util.RequestChecker;

/**
 * Servlet implementation class EditerCollaborateurController
 */
public class CollaborateurNavigatorController extends HttpServlet {
	public static final String CREER_ACTION = "creer";
	public static final String MODIFIER_ACTION = "modifier";
	public static final String LISTER_ACTION = "lister";

	private Map<String, String> routes = new HashMap<>();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CollaborateurNavigatorController() {
		routes.put(CREER_ACTION, "collaborateur/creer.jsp");
		routes.put(MODIFIER_ACTION, "collaborateur/modifier.jsp");
		routes.put(LISTER_ACTION, "collaborateur/lister.jsp");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestAction = getAction(request.getRequestURI());

		if (isAction(requestAction)) {

			switch (requestAction) {

			case CREER_ACTION: {
				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/" + routes.get(requestAction));
				dispatcher.forward(request, response);
				break;
			}
			case MODIFIER_ACTION: {
				String param = request.getParameter("id");
				if (false == RequestChecker.isNullOrEmptyParameterId(param)) {
					request.setAttribute("collaborateur", getCollaborateur(RequestChecker.parameterToInt(param)));
					RequestDispatcher dispatcher = this.getServletContext()
							.getRequestDispatcher("/WEB-INF/views/" + routes.get(requestAction));
					dispatcher.forward(request, response);
				} else {
					response.sendError(404, "Identifiant de collaborateur incorrecte");
				}
				break;
			}
			case LISTER_ACTION: {
				
				List<Collaborateur> list = CollaborateurProcessController.collabService.listerCollaborateurs();
				request.setAttribute("list", list);
				
				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/" + routes.get(requestAction));
				dispatcher.forward(request, response);
					        
				break;
			}
			default:
				break;
			}

		} else {
			response.sendError(400, "Cette action n'existe pas !");
		}
	}

	/**
	 * @param requestUrl
	 * @return : String
	 */
	private String getAction(String requestUrl) {
		String[] elements = requestUrl.split("/");
		return elements[elements.length - 1];
	}

	/**
	 * Retourne vrai si l'action est définit
	 * 
	 * @param requestAction
	 * @return : Boolean
	 */
	private Boolean isAction(String requestAction) {
		return routes.containsKey(requestAction);
	}

	/**
	 * @param id
	 * @return : Collaborateur
	 */
	private Collaborateur getCollaborateur(int id) {
		return new Collaborateur();
	}

	/**
	 * @return : List<Collaborateur>
	 */
	private List<Collaborateur> getList() {
		return new ArrayList<Collaborateur>();
	}
}
