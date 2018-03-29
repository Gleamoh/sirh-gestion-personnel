
	<%@ include file="/WEB-INF/views/templates/base-header.jsp"%>
	<%@ include file="/WEB-INF/views/templates/header.jsp"%>

	<section class="mt-3 mx-5">
		<h1>Nouveau collaborateur</h1>
		<div class="container mt-4">
			<form onsubmit="createCollaborateurProcess(event);" action="<%= request.getContextPath() %>/collaborateurs-process" method="post"
				class="needs-validation" novalidate>
				<div class="form-group row">
					<label for="input-nom" class="col-sm-3 col-form-label">Nom</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="input-nom" name="input-nom"
							placeholder="Nom" required>
						<div class="invalid-feedback">Le nom est obligatoire</div>
					</div>
				</div>
				<div class="form-group row">
					<label for="input-prenom" class="col-sm-3 col-form-label">Pr�nom</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="input-prenom" name="input-prenom"
							placeholder="Pr�nom" required>
						<div class="invalid-feedback">Le pr�nom est obligatoire</div>
					</div>
				</div>
				<div class="form-group row">
					<label for="input-date" class="col-sm-3 col-form-label">Date
						de naissance</label>
					<div class="col-sm-9">
						<input type="date" class="form-control" id="input-date" name="input-date"
							placeholder="... au format 31/12/2017" required>
						<div class="invalid-feedback">La date de naissance est
							obligatoire</div>
					</div>
				</div>
				<div class="form-group row">
					<label for="input-adresse" class="col-sm-3 col-form-label">Adresse</label>
					<div class="col-sm-9">
						<textarea class="form-control" id="input-adresse" name="input-adresse" rows="3"
							placeholder="Adresse" required></textarea>
						<div class="invalid-feedback">L'adresse est obligatoire</div>
					</div>
				</div>
				<div class="form-group row">
					<label for="input-secu" class="col-sm-3 col-form-label">Num�ro
						de s�curit� sociale</label>
					<div class="col-sm-9">
						<input type="text" maxlength="15" class="form-control"
							id="input-secu" name="input-secu" placeholder="Num�ro de s�curit� sociale"
							required>
						<div class="invalid-feedback">Le num�ro de s�curit� sociale
							est obligatoire</div>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-3"></div>
					<div class="col-sm-9">
						<button type="submit" class="btn btn-primary" data-toggle="modal"
							data-target="#confirm">Cr�er</button>
					</div>
				</div>
			</form>

			<!-- Modal -->
			<div class="modal fade" id="confirm" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">Cr�ation
								d'un collaborateur</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<p>Vous �tes sur le point de cr�er un nouveau collaborateur
								:</p>
							<div class="row">
								<div class="col-12 col-lg-6">Nom</div>
								<div class="col-12 col-lg-6">********</div>
							</div>
							<div class="row">
								<div class="col-12 col-lg-6">Pr�nom</div>
								<div class="col-12 col-lg-6">********</div>
							</div>
							<div class="row">
								<div class="col-12 col-lg-6">Date naissance</div>
								<div class="col-12 col-lg-6">********</div>
							</div>
							<div class="row">
								<div class="col-12 col-lg-6">Adresse</div>
								<div class="col-12 col-lg-6">********</div>
							</div>
							<div class="row">
								<div class="col-12 col-lg-6">Num�ro de s�curit� sociale</div>
								<div class="col-12 col-lg-6">********</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Annuler</button>
							<a href="./editer-collab.html" class="btn btn-primary">Confirmer</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%-- <%@ include file="/WEB-INF/views/templates/scripts.jsp"%> --%>
	<%@ include file="/WEB-INF/views/templates/base-footer.jsp"%>
