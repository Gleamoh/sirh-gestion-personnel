
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
					<option value="1">Comptabilité</option>
					<option value="2">Ressources Humaines</option>
					<option value="3">Informatique</option>
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
					List<Collaborateur> list = (List<Collaborateur>) request.getAttribute("list");
					for (Collaborateur c : list) {
				%>

				<!-- card -->
				<div class="col-12 col-mb-6 col-lg-4">
					<div class="card bg-light mb-3">
						<div class="card-header"><%=c.getPrenom() + " " + c.getNom()%></div>
						<div class="row">
							<div class="col-12 col-lg-4">
								<div class="card-body">
									<img
										src="data:image/jpeg;base64,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"
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
												href="<%=request.getContextPath()%>/collaborateur/editer?id=<%=c.getMatricule()%>"
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
