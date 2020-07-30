<%@page import="it.rentalcar.model.Utente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

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
		<c:forEach items='${requestScope["listaNoleggio"]}' var="prenotazione">
			<tr>
				<th scope="row"></th>
				<td>${prenotazione.utente.nome} ${prenotazione.utente.cognome}</td>
				<td>${prenotazione.automobile.modello} ${prenotazione.automobile.targa} ${prenotazione.automobile.casaCostruttrice}</td>
				<td>${prenotazione.inizioPrenotazione}</td>
				<td>${prenotazione.finePrenotazione}</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>