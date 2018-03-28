
<% String path = request.getContextPath(); %>
<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">LOG</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="<%= path %>/collaborateurs/lister">Collaborateurs</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%= path %>/statistiques/lister">Statistiques</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%= path %>/activites/lister">Activités</a></li>
			</ul>
		</div>
	</nav>
</header>