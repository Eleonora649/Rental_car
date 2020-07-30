<%@page import="it.rentalcar.model.Utente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Modello</th>
			<th scope="col">Targa</th>
			<th scope="col">Casa Costruttrice</th>
			<th scope="col">Anno di immatricolazione</th>
			<th scope="col">Categoria</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items='${requestScope["listaAutomobili"]}' var="auto">
			<tr>
				<th scope="row"></th>
				<td>${auto.modello}</td>
				<td>${auto.targa}</td>
				<td>${auto.casaCostruttrice}</td>
				<td>${auto.annoImmatricolazione}</td>
				<td>${auto.categoria.nome}</td>
				<td>
					<c:if test="${currentUser=admin}">
						<a href="eliminaauto?el=<c:out value="${auto.idAutomobile}"/>" type="button" class="btn btn-danger"> Elimina </a>
						<a href="modificaauto?mod=<c:out value="${auto.idAutomobile}"/>" type="button" class="btn btn-danger"> Modifica </a>
					</c:if>
					
					
						<a href="prenotaauto?pren=<c:out value="${auto.idAutomobile}"/>" type="button" class="btn btn-danger"> Prenota</a>
					
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>