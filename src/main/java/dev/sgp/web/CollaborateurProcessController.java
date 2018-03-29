package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

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
 * Servlet implementation class ListerCollaborateursController
 */
public class CollaborateurProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	public static DepartementService depService = Constantes.DEP_SERVICE;
	private final int SECU_LENGTH = 15;
	private final String DEFAULT_IMAGE = "data:image/jpeg;base64,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";
	private static final String METHOD_DELETE = "DELETE";
	private static final String METHOD_GET = "GET";
	private static final String METHOD_POST = "POST";
	private static final String METHOD_PUT = "PUT";
	private static final String METHOD_VIEW = "VIEW";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CollaborateurProcessController() {

		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();

		if (method.equals(METHOD_POST)) {
			String overideMethod = req.getParameter("_method");

			if (null != overideMethod && overideMethod.toUpperCase().equals(METHOD_VIEW)) {
				doView(req, resp);
			} else if (null != overideMethod && overideMethod.toUpperCase().equals(METHOD_PUT)) {
				doPut(req, resp);
			} else if (null != overideMethod && overideMethod.toUpperCase().equals(METHOD_DELETE)) {
				doDelete(req, resp);
			} else {
				doPost(req, resp);
			}

		} else if (method.equals(METHOD_GET)) {
			doGet(req, resp);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setStatus(200);
		response.getWriter().write("get collaborateur process");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> params = new HashMap<>();
		params.put("nom", request.getParameter("input-nom"));
		params.put("prenom", request.getParameter("input-prenom"));
		params.put("date", request.getParameter("input-date"));
		params.put("adresse", request.getParameter("input-adresse"));
		params.put("secu", request.getParameter("input-secu"));

		String message = RequestChecker.checkParameters(params);

		if (null != message || false == checkSecu(params.get("secu"))) {
			response.sendError(400, message);
		} else {

			// générer le matricule
			DateTimeFormatter matriculeformatter = DateTimeFormatter.ofPattern("yyyyMMddHms");
			String matricule = LocalDateTime.now().format(matriculeformatter).toUpperCase();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(params.get("date"), formatter);

			Collaborateur collaborateur = new Collaborateur(matricule, params.get("nom"), params.get("prenom"),
					params.get("adresse"), params.get("secu"),
					generateEmail(params.get("prenom"), params.get("nom")).toLowerCase(), DEFAULT_IMAGE, localDate,
					LocalDateTime.now(), true);

			collabService.sauvegarderCollaborateur(collaborateur);

			response.sendRedirect("collaborateurs/lister");
		}

	}

	/*
	 * Retourner la liste des collaborateurs
	 */
	private void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("List");
		response.setStatus(200);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPut(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String, String> params = new HashMap<>();

		params.put("adresse", req.getParameter("input-adresse").trim());
		params.put("intitulePoste", req.getParameter("input-nom-poste").trim());
		params.put("idDepartement", req.getParameter("input-dep").trim());
		params.put("banque", req.getParameter("input-banque").trim());
		params.put("bic", req.getParameter("input-bic").trim());
		params.put("iban", req.getParameter("input-iban").trim());
		params.put("phone", req.getParameter("input-tel").trim());
		params.put("active", req.getParameter("input-active"));
		params.put("matricule", req.getParameter("_matricule").trim());

		String message = RequestChecker.checkParameters(params);

		if (null != message || false == checkSecu(params.get("secu"))) {
			resp.sendError(400, message);
		} else {
			Optional<Collaborateur> optional = collabService.listerCollaborateurs().stream()
					.filter(c -> c.getMatricule().equals(params.get("matricule"))).findFirst();

			if (optional.isPresent()) {
				Collaborateur c = optional.get();
				c.setAdresse(params.get("adresse"));
				c.setBanque(params.get("banque"));
				c.setIntitulePoste(params.get("intitulePoste"));

				Optional<Departement> optionalDep = depService.listerDepartement().stream()
						.filter(d -> d.getId() == Integer.parseInt(params.get("idDepartement"))).findFirst();

				c.setDepartement(optionalDep.isPresent() ? optionalDep.get() : null);

				c.setIban(params.get("iban"));
				c.setIntitulePoste(params.get("intitulePoste"));
				c.setPhone(params.get("phone"));
				c.setEstActif(params.get("estActif").equals("0") ? false : true);
			}
		}
		
		resp.getWriter().write("");
		resp.sendRedirect("collaborateurs/lister");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doDelete(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(200);
		resp.getWriter().write("Delete collab process");
	}

	/**
	 * @param secu
	 * @return : Boolean
	 */
	private Boolean checkSecu(String secu) {
		return SECU_LENGTH == secu.length();
	}

	/**
	 * @param prenom
	 * @param nom
	 * @return : String
	 */
	private String generateEmail(String prenom, String nom) {
		ResourceBundle file = ResourceBundle.getBundle("application");
		return prenom + "." + nom + "@" + file.getString("domaine");
	}
}
