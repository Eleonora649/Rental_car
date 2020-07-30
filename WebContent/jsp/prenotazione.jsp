<%-- <%@ page session="true" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<div class="">
	<c:out value="${requestScope.automobile}"/>
	<table class="table">
		<thead>
			<tr>
				<th scope="col"></th>
				<th scope="col">Modello</th>
				<th scope="col">Targa</th>
				<th scope="col">Casa Costruttrice</th>
				<th scope="col">Anno di immatricolazione</th>
				<th scope="col">Categoria</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row"></th>
				<td>${automobile.modello}</td>
				<td>${automobile.targa}</td>
				<td>${automobile.casaCostruttrice}</td>
				<td>${automobile.annoImmatricolazione}</td>
				<td>${automobile.categoria.nome}</td>
			</tr> 
			<td></td><td></td>
			<td><div>
				<input type="date" name="inizioNoleggio" id="inizioNoleggio" 
					value="" min="" max="">
			</div></td>
			<td><div>
				<input type="date" name="fineNoleggio" id="fineNoleggio"
					value="" min="" max="">
			</div></td>
			<td><div>
			 	<a href="riepilogoprenotazione" type="button" class="btn btn-danger"> Prenota</a>
			</div> </td>
		</tbody>
	</table>
</div>