<%@page import="it.rentalcar.model.Utente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<c:out value="${requestScope.currentUser}"/>
<c:out value="${requestScope.automobile}"/>
<c:out value="${requestScope.prenotazione}"/>
	<table class="table">
		<thead>
			<tr>
				<th scope="col"></th>
				<th scope="col">Utente</th>
				<th scope="col">Automobile</th>
				<th scope="col">Inizio noleggio </th>
				<th scope="col">Fine noleggio</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<th scope="row"></th>
					<td>${currentUser.nome} ${currentUser.cognome}</td>
					<td>${automobile.modello} ${automobile.targa} ${automobile.casaCostruttrice}</td>
					<td><fmt:formatDate value='${prenotazione.inizioPrenotazione}' var='data' type='date' pattern='yyyy-MM-dd'/>${prenotazione.inizioPrenotazione}</td>
					<td><fmt:formatDate value='${prenotazione.finePrenotazione}' var='data' type='date' pattern='yyyy-MM-dd'/>${prenotazione.finePrenotazione}</td>
				</tr>
				<tr> <td></td><td></td><td></td><td></td>
					<td>
			 			<a href="start" type="button" class="btn btn-primary"> Conferma</a>
					</td>
				</tr>
		</tbody>
	</table>