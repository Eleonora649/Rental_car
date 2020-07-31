<%@page import="it.rentalcar.model.Utente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<table class="table">
	<thead>
		<tr>
			<th scope="col"></th>
			<th scope="col">Nome</th>
			<th scope="col">Cognome</th>
			<th scope="col">Data di nascita</th>
			<th scope="col">Email</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items='${requestScope["listaUtenti"]}' var="utente">
			<tr>
				<th scope="row"></th>
				<td>${utente.nome}</td>
				<td>${utente.cognome}</td>
				<td><fmt:formatDate value='${utete.dataDiNascita}' var='data' type='date' pattern='yyyy-MM-dd'/>${utente.dataDiNascita}</td>				
				<td>${utente.email}</td>
				<td>
					<button type="submit" class="btn btn-primary" id="buttonDelete" value="" 
						onclick="sendForm('${utente.idUtente}','eliminautente');"> Elimina </button>
					<button type="submit" class="btn btn-primary" id="buttonEdit" value="" 
						onclick="sendForm('${utente.idUtente}','/modificautente');"> Modifica </button>
				</td> 
			</tr>
		</c:forEach>
	</tbody>
</table>
<form method="post" action="" name="myForm">
	<input type="hidden" id="idUtente" name="idUtente" />
</form>
