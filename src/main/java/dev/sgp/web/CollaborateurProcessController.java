package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
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
	private final String DEFAULT_IMAGE = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAMAAABHPGVmAAAAPFBMVEV/wMT////P5+m3296XzM+HxMef0NPf7/D3+/vX6+zn8/T7/f2PyMvv9/jH4+Wv19qn1NbA4OLM5uek0tVM7mriAAAESElEQVRogb1a2aKrIAxEdvfq+f9/vaUWZclia6/zdk7VgQSSTEA0J+EmZbXYoa2a3Nl3xZmHWpV8PoVW7U9IvHzABBEP6S+SuNnQFAFmZgxHkkjLM2yw8ksSOZylCBgIGpTEnZ7FPhvUaAiJV59SBChkCcAk7Ql3QzDwioZIvpsGMRmAZER23jno8QxJ96WpIkzHk8hrFAHVYi5JfsBRs4j/wFGxiI84jFZr265Kc36TOAnN8WRwYx+e671bGB6JkXTka2UMbC1J08EkI/WSWZoKExVBzQiReGoPDmDw66hXtAdIqFii6w22TZ4K1aomaal5IBxMCNqjZSTxhEMMkV2pIGSiwSIJZSyFMQSsJ158kzjiUU1WIz3lFpeRUE9OFAed4GxKQm31oadJyAHKhITaVaRHAiZqhAcJNREkbScgs5zcSagJD2wR2lB7xUYSamlF31Egi2X3Jpmph2aehCxu5o2E2uynSBbq/bDtBZeqrpIE1wvGpJfNJR4vEvKR8AwH0qciMJAx/gnNk/zRX2ifJEzhOwBlZ46e0THqScJUvhd3vAi2EIxLLsauFxpBbvdtIAxYSeYEOw7OXh0rLSfBCx5mEfMfUILXn3DNFTHyGtmKE7LqQeXGE9LvlHIzhER3F3VZMhQ0cfmP1T4O1GAXdHINoKYPYNf/D1io6vE7lsov/fQzp+94FCz9T/3xwt/SFs7v3cT09D6DWdyWVfxbqHTxz+WjnhhFMY1xEl4Ns1KzPkw3nmq9sXtepalx02+Z8vIL53/NBUjrclcELVqqu45J8pYO9WaptvoCVEnMYlZk0hrqfBWUKNBsIlt9E5V+IWH9KjcB7UVJekcUEhYohvxra0DdOULSEyWRheL7e95Q2kejvsaLO2i0eygBQz/WOFBomQo3IfYeD/grUre0WMGN1EH7gOD8Aq8xVDrAHzkaA4iShJTKAxNBSFJPum7wTKF2lkTkHNaxSdbIH/xEXby85VwtYpCaMRsN0p2qbP8WppXEBsLGC1lKR0qLSkdEiV3W5Ygp8m2LtVyKiLw3C0rXr/Drhb2RsrKoYI62R97AwQRc4TqkVZEX4EkDJ5+Kgg1RLkLEc302lrQVlXkFET1VjEPWYBqmsqZatsCQ6rpa6Mj68MkjeXswHSf8buPLdYNp78Tw8T/xE4fFkcVVsKAcx/KqWraJKVHNkyY/MN0EyGO0VfM5NZjB+qcHC9ZXb5K6BWijZxHUrvAyjiwIR7+mc4UOBLKjDaPnFjIIUEHug2zn9OAGPtooD2nMYJXsyhkFlmoefScXO+SbFTmkAdKXeTLNampdN3rf9xvLNo++937sXDup+fn9Ko2gx01Ep9AM+sm2TJN0y9LKdV3U/NADWjcSB2f3HAHec5h5z7HsPQfM9xyV33Po39xyfeHryXx2EaO55UpJwA2XY140//+aT8ANF5YCbrh6teG/XyKLuHId7h+wGSazJu6dgAAAAABJRU5ErkJggg==";
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

		if (method.equals(METHOD_VIEW)) {
			doView(req, resp);
			
		} else if (method.equals(METHOD_POST)) {
			doPost(req, resp);

		} else if (method.equals(METHOD_PUT)) {
			doPut(req, resp);

		} else if (method.equals(METHOD_DELETE)) {
			doDelete(req, resp);

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

		String nom = request.getParameter("input-nom");
		String prenom = request.getParameter("input-prenom");
		String date = request.getParameter("input-date");
		String adresse = request.getParameter("input-adresse");
		String secu = request.getParameter("input-secu");

		Map<String, String> params = new HashMap<>();

		params.put("nom", nom.trim());
		params.put("prenom", prenom.trim());
		params.put("date", date.trim());
		params.put("adresse", adresse.trim());
		params.put("secu", secu.trim());

		String message = "Les paramètres suivants sont incorrects: ";

		for (Map.Entry<String, String> p : params.entrySet()) {
			if (RequestChecker.isNullOrEmptyParameter(p.getValue())) {
				message += p.getKey() + ", ";
			}
		}

		if (false == message.equals("Les paramètres suivants sont incorrects: ")
				|| false == checkSecu(params.get("secu"))) {
			response.sendError(400, message);
		} else {

			Collaborateur collaborateur = new Collaborateur();

			collaborateur.setNom(params.get("nom"));
			collaborateur.setPrenom(params.get("prenom"));

			// générer le matricule
			String matricule = (params.get("nom") + "-" + params.get("nom") + params.get("date")).toUpperCase();
			collaborateur.setMatricule(matricule);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(params.get("date"), formatter);

			collaborateur.setDateNaissance(localDate);
			collaborateur.setAdresse(params.get("adresse"));
			collaborateur.setNumeroSecuriteSociale(params.get("secu"));
			collaborateur.setDateHeureCreation(LocalDateTime.now());
			collaborateur.setEmailProfessionnel(generateEmail(params.get("prennom"), params.get("nom")));
			collaborateur.setPhoto(DEFAULT_IMAGE);
			collaborateur.setEstActif(true);
			
			collabService.sauvegarderCollaborateur(collaborateur);
			
			response.sendRedirect("collaborateurs/lister");
			//request.getRequestDispatcher("collaborateurs/lister").forward(request, response);
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

		resp.setStatus(200);
		resp.getWriter().write("Put collab process");
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
