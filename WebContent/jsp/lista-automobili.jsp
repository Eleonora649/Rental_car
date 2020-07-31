<%@page import="it.rentalcar.model.Utente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<% Utente utente = (Utente) session.getAttribute("currentUser"); %>

<table class="table">
	
	<!-- <form method="post" margin-top="5px">
		<select id="categoria" name="categoria"> 
			<option value="0">Tutte le categorie</option>
			<option value="1">Suv</option>
			<option value="2">Minivan</option>
			<option value="3">Furgone</option>
		</select>
	</form>	 -->
	
	<thead>
		<tr margin-top="5px">
			<th scope="col"></th>
			<th scope="col">Modello</th>
			<th scope="col">Targa</th>
			<th scope="col">Casa Costruttrice</th>
			<th scope="col">Anno di immatricolazione</th>
			<th scope="col">Categoria</th>
			<th scope="col"></th>
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
				<c:choose>
					<c:when test="${sessionScope.utente=='admin'}">
						<a href="eliminaauto?el=<c:out value="${auto.idAutomobile}"/>" type="button" class="btn btn-primary"> Elimina </a>
						<a href="modificaauto?mod=<c:out value="${auto.idAutomobile}"/>" type="button" class="btn btn-primary"> Modifica </a>
					</c:when>
					<c:when test="${sessionScope.utente!='null'}">					
						<a href="prenotaauto?pren=<c:out value="${auto.idAutomobile}"/>" type="button" class="btn btn-primary"> Prenota</a>
					</c:when>
					<c:otherwise> <a href="login" type="button" class="btn btn-primary"> Prenota</a> </c:otherwise>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>