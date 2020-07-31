<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="start">Home
						<span class="sr-only">(current)</span>
				</a></li>
			<c:if test="${sessionScope.currentUser == null }">
				<li class="nav-item"><a class="nav-link" href="login">Sign in</a></li>
				<li class="nav-item"><a class="nav-link" href="registrautente">Sign up</a></li>
			</c:if>
			<c:if test="${sessionScope.currentUser !=null }" >
				<li class="nav-item"><a class="nav-link" href="areapersonale">Area Personale</a>
			</c:if> 
				
				<!-- <li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Dropdown </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a>	
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div></li> -->
				
				<li class="nav-item"><a class="nav-link" href="listaautomobili">Catalogo</a></li>
				<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>
</div>