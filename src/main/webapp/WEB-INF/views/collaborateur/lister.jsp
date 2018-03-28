
<%@page import="java.util.List"%>

	<%@ include file="/WEB-INF/views/templates/base-header.jsp"%>
	<%@ include file="/WEB-INF/views/templates/header.jsp"%>

	<section>
		<div class="mx-5">

			<div class="row">
				<div class="col-lg-9"></div>
				<div class="col-12 col-lg-1">
					<a href="<%= request.getContextPath() %>/collaborateurs/creer" class="btn btn-primary mt-3">Ajouter
						un nouveau collaborateur</a>
				</div>
			</div>
			<h1>Les collaborateurs</h1>

			<div class="row">
				<div class="col-12 col-lg-4">Rechercher un nom ou un prénom
					qui commence par :</div>
				<div class="col-12 col-lg-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control"
							placeholder="nom ou prénom ..." aria-label=""
							aria-describedby="basic-addon2">
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="button">Rechercher</button>
						</div>
					</div>
				</div>
				<div class="col-12 col-lg-4">
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input"
							id="customCheck1"> <label class="custom-control-label"
							for="customCheck1">Voir les collaborateurs désactivés</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12 col-lg-4">Filtrer par département :</div>
				<div class="col-12 col-lg-4">
					<select class="custom-select">
						<option selected>Tous</option>
						<option value="1">Comptabilité</option>
						<option value="2">Ressources Humaines</option>
						<option value="3">Informatique</option>
					</select>
				</div>

			</div>
		</div>
	</section>
	<section>
		<%
			List<String> noms = (List<String>) request.getAttribute("listeNoms");
			for (String nom : noms) {
		%>
		<p>
			<%=nom%></p>
		<%
			}
		%>
	</section>
	<section>
		<div class="mx-5 mt-5" id="list-collab"></div>
	</section>

	<%@ include file="/WEB-INF/views/templates/scripts.jsp"%>
	<%@ include file="/WEB-INF/views/templates/base-footer.jsp"%>
