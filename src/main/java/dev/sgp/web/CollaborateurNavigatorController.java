package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;
import dev.sgp.util.RequestChecker;

/**
 * Servlet implementation class EditerCollaborateurController
 */
public class CollaborateurNavigatorController extends HttpServlet {

	public static CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	public static DepartementService depService = Constantes.DEP_SERVICE;

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
				doCreer(request, response);
				break;
			}
			case MODIFIER_ACTION: {
				doModifier(request, response);
				break;
			}
			case LISTER_ACTION: {
				doLister(request, response);
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
	private Optional<Collaborateur> getCollaborateur(String id) {
		return collabService.listerCollaborateurs().stream().filter(c -> c.getMatricule().equals(id)).findFirst();
	}

	/**
	 * @return : List<Collaborateur>
	 */
	private List<Collaborateur> getList() {
		return new ArrayList<Collaborateur>();
	}

	private void doCreer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/" + routes.get(CREER_ACTION));
		dispatcher.forward(request, response);
	}

	private void doModifier(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String param = request.getParameter("id");
		
		if (false == RequestChecker.isNullOrEmptyParameter(param)) {
			Optional<Collaborateur> optional = getCollaborateur(param);
		
			if(optional.isPresent()) {
				request.setAttribute("collaborateur", optional.get());
				
				List<Departement> departements = depService.listerDepartement();
				request.setAttribute("departements", departements);
				
				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/" + routes.get(MODIFIER_ACTION));
				dispatcher.forward(request, response);
			} else {
				response.sendError(404, "Impossible de trouver le collaborateur");
			}
		} else {
			response.sendError(404, "Identifiant de collaborateur incorrecte");
		}
	}

	private void doLister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
		List<Departement> departements = depService.listerDepartement();
		request.setAttribute("collaborateurs", collaborateurs);
		request.setAttribute("departements", departements);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/" + routes.get(LISTER_ACTION));
		dispatcher.forward(request, response);
	}
}
