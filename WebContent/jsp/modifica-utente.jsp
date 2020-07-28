<%@page import="it.rentalcar.model.Utente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<div class="container">
	<form method="post">
		<c:out value="${utente.id}"/>
			<div class="form-group">
				<label for="inputNome">Nome</label> 
				<input type="text" required class="form-control" name="nome" id="inputNome" value="${utente.nome}"/>
			</div>
	
			<div class="form-group">
				<label for="inputCognome">Cognome</label> 
				<input type="text" required class="form-control" name="cognome" id="inputCognome" value="${utente.cognome}"/>
			</div>
	
			<div class="form-group">
				<label for="inputDataDiNascita">Data di nascita</label> 
				<input type="date" required class="form-control" name="data" id="inputDataDiNascita" value="${utete.dataDiNascita}"/>
			</div>
	
			<div class="form-group">
				<label for="inputEmail">Email</label> 
				<input type="email" required class="form-control" name="email" id="inputEmail" value="${utente.email}"/>
			</div>
	
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputPassword">Password</label> 
					<input type="password" required class="form-control" name="password" id="inputPassword"/>
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword2">Conferma password</label> 
					<input type="password" required class="form-control" name="cpassword" id="inputPassword2">
				</div>
			</div>
		<button type="submit" class="btn btn-primary">Modifica</button>
	</form>
</div>