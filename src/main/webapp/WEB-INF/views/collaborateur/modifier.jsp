<%@page import="java.util.List"%>

<%@ include file="/WEB-INF/views/templates/base-header.jsp"%>
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<h1>Modifier</h1>
<p>
	<%=request.getAttribute("collaborateur").toString()%>
</p>

<section class="mt-3 mx-5">
	<div class="row">
		<div class="col-12 col-lg-3 mt-5">
			<img
				src="http://cheb-room.ru/uploads/cheb/2016/11/w9RC4W-QqXw-200x200.jpg"
				class="rounded mx-auto d-block" alt="omer">
		</div>
		<div class="col-12 col-lg-9">
			<div class="row">
				<div class="col-12 col-lg-6">
					<h1>Nom Prénom - Matricule</h1>
				</div>
				<div class="col-12 col-lg-6 mt-3">
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input"
							id="customCheck1"> <label class="custom-control-label"
							for="customCheck1">Désactiver</label>
					</div>
				</div>
			</div>

			<form id="edit-form" class="needs-validation" methode="put" action="<%= request.getContextPath()%>/collabotateur-process?id=/<%= request.getAttribute("id") %>" novalidate>
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
										<select id="input-civilite" class="custom-select">
											<option value="1">Madame</option>
											<option value="2">Monsieur</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-nom" class="col-sm-3 col-form-label">Nom</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="input-nom"
											placeholder="Nom" required>
										<div class="invalid-feedback">Le nom est obligatoire</div>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-prenom" class="col-sm-3 col-form-label">Prénom</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="input-prenom"
											placeholder="Prénom" required>
										<div class="invalid-feedback">Le prénom est obligatoire
										</div>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-date" class="col-sm-3 col-form-label">Date
										de naissance</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="input-date"
											placeholder="Date de naissance" required>
										<div class="invalid-feedback">La date de naissance est
											obligatoire</div>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-adresse" class="col-sm-3 col-form-label">Adresse</label>
									<div class="col-sm-9">
										<textarea class="form-control" id="input-adresse" rows="3"
											placeholder="Adresse" required></textarea>
										<div class="invalid-feedback">L'adresse est obligatoire
										</div>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-secu" class="col-sm-3 col-form-label">Numéro
										de sécurité sociale</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="input-secu"
											placeholder="Numéro de sécurité sociale" required>
										<div class="invalid-feedback">Le numéro de sécurité
											sociale est obligatoire</div>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-tel" class="col-sm-3 col-form-label">Téléphone</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="input-tel"
											placeholder="Téléphone" required>
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
										<select id="input-dep" class="custom-select">
											<option value="1">Compta</option>
											<option value="2">Rh</option>
											<option value="3">R et D</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-dep-nom" class="col-sm-3 col-form-label">Nom</label>
									<div class="col-sm-9">
										<input form="edit-form" type="text" class="form-control"
											id="input-dep-nom" placeholder="Nom" required>
										<div class="invalid-feedback">Le nom est obligatoire</div>
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
									<label for="input-iban" class="col-sm-3 col-form-label">IBAN</label>
									<div class="col-sm-9">
										<input form="edit-form" type="text" class="form-control"
											id="input-iban" placeholder="Nom" required>
										<div class="invalid-feedback">L'IBAN est obligatoire</div>
									</div>
								</div>
								<div class="form-group row">
									<label for="input-bic" class="col-sm-3 col-form-label">BIC</label>
									<div class="col-sm-9">
										<input form="edit-form" type="text" class="form-control"
											id="input-bic" placeholder="Nom" required>
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