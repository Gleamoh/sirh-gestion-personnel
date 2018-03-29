<%@page import="java.time.ZonedDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="javax.swing.text.DateFormatter"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>
<%@page import="java.util.List"%>

<%@ include file="/WEB-INF/views/templates/base-header.jsp"%>
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<%
	Collaborateur c = (Collaborateur) request.getAttribute("collaborateur");
%>

<section class="mt-3 mx-5">
	<div class="row">
		<div class="col-12 col-lg-3 mt-5">
			<img src="<%=c.getPhoto()%>" class="rounded mx-auto d-block"
				alt="photo">
		</div>
		<div class="col-12 col-lg-9">
			<div class="row">
				<div class="col-12 col-lg-6">
					<h1>Nom Prénom - Matricule</h1>
				</div>
				<div class="col-12 col-lg-6 mt-3">
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input"
							id="customCheck1" name="input-active" value="1" <%= c.getEstActif() ? "" : "checked" %>> <label
							class="custom-control-label" for="customCheck1">Désactiver</label>
					</div>
				</div>
			</div>

			<form id="edit-form" class="needs-validation" method="post"
				action="<%=request.getContextPath()%>/collaborateurs-process"
				novalidate>
				<input type="hidden" name="_method" value="PUT" form="edit-form"/>
				<input type="hidden" name="_matricule" value="<%= c.getMatricule() %>" form="edit-form"/>
				<div id="accordion">
					<div class="card">
						<div class="card-header" id="headingOne">
							<h5 class="mb-0">
								<button class="btn btn-link" data-toggle="collapse"
									data-target="#collapseOne" aria-expanded="true"
									aria-controls="collapseOne">Identité</button>
							</h5>
						</div>

						<div id="collapseOne" class="collapse show"
							aria-labelledby="headingOne" data-parent="#accordion">
							<div class="card-body">
								<div class="form-group row">
									<label for="input-civilite" class="col-sm-3 col-form-label">Civilité</label>
									<div class="col-sm-9">
										<select id="input-civilite" name="input-civilite"
											class="custom-select">
											<option value="1">Madame</option>
											<option value="2">Monsieur</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-nom" class="col-sm-3 col-form-label">Nom</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="input-nom"
											name="input-nom" placeholder="Nom" value="<%=c.getNom()%>"
											disabled>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-prenom" class="col-sm-3 col-form-label">Prénom</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="input-prenom"
											name="input-nom" placeholder="Prénom"
											value="<%=c.getPrenom()%>" disabled>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-date" class="col-sm-3 col-form-label">Date
										de naissance</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="input-date"
											name="input-date" placeholder="Date de naissance"
											value="<%=c.getDateNaissance().format(DateTimeFormatter.ofPattern("dd-MM-YYYY"))%>"
											disabled>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-adresse" class="col-sm-3 col-form-label">Adresse</label>
									<div class="col-sm-9">
										<textarea class="form-control" id="input-adresse"
											name="input-adresse" rows="3" placeholder="Adresse" required>"<%=c.getAdresse()%></textarea>
										<div class="invalid-feedback">L'adresse est obligatoire
										</div>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-secu" class="col-sm-3 col-form-label">Numéro
										de sécurité sociale</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="input-secu"
											name="input-secu" placeholder="Numéro de sécurité sociale"
											value="<%=c.getNumeroSecuriteSociale()%>" required>
										<div class="invalid-feedback">Le numéro de sécurité
											sociale est obligatoire</div>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-tel" class="col-sm-3 col-form-label">Téléphone</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="input-tel"
											name="input-tel" placeholder="Téléphone"
											value="<%=c.getPhone()%>" required>
										<div class="invalid-feedback">Le numéro de téléphone est
											obligatoire</div>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="card">
						<div class="card-header" id="headingTwo">
							<h5 class="mb-0">
								<button class="btn btn-link collapsed" data-toggle="collapse"
									data-target="#collapseTwo" aria-expanded="false"
									aria-controls="collapseTwo">Poste</button>
							</h5>
						</div>
						<div id="collapseTwo" class="collapse"
							aria-labelledby="headingTwo" data-parent="#accordion">
							<div class="card-body">
								<div class="form-group row">
									<label for="input-dep" class="col-sm-3 col-form-label">Département</label>
									<div class="col-sm-9">
										<select id="input-dep" name="input-dep" class="custom-select">
											<%
												List<Departement> departements = (List<Departement>) request.getAttribute("departements");
												String selected = "";
												for (Departement d : departements) {
													if (null != c.getDepartement() && d.getId() == c.getDepartement().getId()) {
														selected = "selected";
													}
											%>
											<option value="<%=d.getId()%>" <%=selected%>><%=d.getName()%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-dep-nom" class="col-sm-3 col-form-label">Nom
										du poste</label>
									<div class="col-sm-9">
										<input form="edit-form" type="text" class="form-control"
											id="input-nom-poste" name="input-nom-poste"
											placeholder="Nom du poste"
											value="<%=c.getIntitulePoste()%>" required>
										<div class="invalid-feedback">Le nom du poste est
											obligatoire</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="card">
						<div class="card-header" id="headingThree">
							<h5 class="mb-0">
								<button class="btn btn-link collapsed" data-toggle="collapse"
									data-target="#collapseThree" aria-expanded="false"
									aria-controls="collapseThree">Cordonnées Bancaires</button>
							</h5>
						</div>
						<div id="collapseThree" class="collapse"
							aria-labelledby="headingThree" data-parent="#accordion">
							<div class="card-body">
								<div class="form-group row">
									<label for="input-banque" class="col-sm-3 col-form-label">Banque</label>
									<div class="col-sm-9">
										<input form="edit-form" type="text" class="form-control"
											id="input-banque" name="input-banque"
											placeholder="Nom de la banque" value="<%=c.getBanque()%>"
											required>
										<div class="invalid-feedback">Le banque est obligatoire</div>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-iban" class="col-sm-3 col-form-label">IBAN</label>
									<div class="col-sm-9">
										<input form="edit-form" type="text" class="form-control"
											id="input-iban" name="input-iban" placeholder="Nom"
											value="<%=c.getIban()%>" required>
										<div class="invalid-feedback">L'IBAN est obligatoire</div>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-bic" class="col-sm-3 col-form-label">BIC</label>
									<div class="col-sm-9">
										<input form="edit-form" type="text" class="form-control"
											id="input-bic" name="input-bic" placeholder="Nom"
											value="<%=c.getBic()%>" required>
										<div class="invalid-feedback">Le BIC est obligatoire</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
			<div class="mt-3">
				<button form="edit-form" type="submit" class="btn btn-primary"
					data-toggle="modal" data-target="#confirm">Sauvegarder</button>
			</div>
		</div>
	</div>
	</div>
	</div>



</section>


<%@ include file="/WEB-INF/views/templates/scripts.jsp"%>
<%@ include file="/WEB-INF/views/templates/base-footer.jsp"%>