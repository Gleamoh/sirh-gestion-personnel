
<%@page import="java.util.ArrayList"%>
<%@page import="dev.sgp.entite.Departement"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="java.util.List"%>

<%@ include file="/WEB-INF/views/templates/base-header.jsp"%>
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<section>
	<div class="mx-5">

		<div class="row">
			<div class="col-lg-9"></div>
			<div class="col-12 col-lg-1">
				<a href="<%=request.getContextPath()%>/collaborateurs/creer"
					class="btn btn-primary mt-3">Ajouter un nouveau collaborateur</a>
			</div>
		</div>
		<h1>Les collaborateurs</h1>

		<div class="row">
			<div class="col-12 col-lg-4">Rechercher un nom ou un prénom qui
				commence par :</div>
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
					<%
						List<Departement> departements = (List<Departement>)request.getAttribute("departements");
						for(Departement d : departements) {
					%>
					<option value="<%= d.getId()%>"><%= d.getName() %></option>
					<% } %>
				</select>
			</div>

		</div>
	</div>
</section>
<section>


	<section>
		<div class="mx-5 mt-5">
			<div class="row">
				<%
					List<Collaborateur> collaborateurs = (List<Collaborateur>) request.getAttribute("collaborateurs");
					for (Collaborateur c : collaborateurs) {
				%>

				<!-- card -->
				<div class="col-12 col-md-6 col-lg-4">
					<div class="card bg-light mb-3">
						<div class="card-header"><%=c.getPrenom() + " " + c.getNom()%></div>
						<div class="row">
							<div class="col-12 col-lg-4">
								<div class="card-body">
									<img
										src="<%= c.getPhoto() %>"
										class="rounded mx-auto d-block mt-2" alt="...">
								</div>
							</div>
							<div class="col-12 col-lg-8">
								<div class="card-body">
									<p class="card-text">
									<div class="row">
										<div class="col-4">Email:</div>
										<div class="col-8"><%=c.getEmailProfessionnel()%></div>
									</div>
									<div class="row">
										<div class="col-4">Matricule:</div>
										<div class="col-8"><%=c.getMatricule()%></div>
									</div>
									<div class="row">
										<div class="col-4">Activé ?</div>
										<div class="col-8"><%=c.getEstActif() ? "Oui" : "Non"%></div>
									</div>
									<div class="row">
										<div class="col-lg-6">
											<!-- vide -->
										</div>
										<div class="col-12 col-lg-3">
											<a
												href="<%=request.getContextPath()%>/collaborateurs/modifier?id=<%=c.getMatricule()%>"
												class="btn btn-primary btn-sm mt-2">Editer</a>
										</div>
									</div>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- end card -->
				<%
					}
				%>
			</div>
		</div>
	</section>

</section>
<section>
	<div class="mx-5 mt-5" id="list-collab"></div>
</section>

<%@ include file="/WEB-INF/views/templates/scripts.jsp"%>
<%@ include file="/WEB-INF/views/templates/base-footer.jsp"%>
