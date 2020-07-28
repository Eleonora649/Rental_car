<%@page import="it.rentalcar.model.Utente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
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
				<td><fmt:formatDate value='${utete.dataDiNascita}' var='data' type='date' pattern='yyyy-MM-dd'/>${utente.dataDiNascita}
				<%-- <fmt:formatDate type="string" pattern="yyyy-MM-dd" value="${utete.dataDiNascita}"/> --%>
				</td>
				<td>${utente.email}</td>
											<%-- <td>
												<a href="eliminautente?el=<c:out value="${utente.idUtente}"/>" type="button" class="btn btn-danger"> Elimina </a>
												<a href="modificautente?mod=<c:out value="${utente.idUtente}"/>" type="button" class="btn btn-danger"> Modifica </a>
											</td> --%>
				<td><form method="post" action="" name="myForm">
						<input type="button" id="idUtente" value="" onclick="submit"> Elimina </input>
						<input type="button" id="idUtente" value="" onclick="submit"> Modifica </input>
				</form></td> 
			</tr>
		</c:forEach>
	</tbody>
</table>

