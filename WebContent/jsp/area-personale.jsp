<c:out value="${requestScope.currentUser}"/>
<br><br>
<h6>Dati personali</h6>
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
			<tr>
				<th scope="row"></th>
				<td>${currentUser.nome}</td>
				<td>${currentUser.cognome}</td>
				<td><fmt:formatDate value='${currentUser.dataDiNascita}' var='data' type='date' pattern='yyyy-MM-dd'/>${currentUser.dataDiNascita}</td>				
				<td>${currentUser.email}</td>
				<td>
			</tr>
	</tbody>
</table>
<br><br>

<h6>Auto Noleggita</h6>
<table class="table">
	<thead>
		<tr>
			<th scope="col"></th>
			<th scope="col">Modello</th>
			<th scope="col">Targa</th>
			<th scope="col">Periodo di noleggio</th>
			<th scope="col">Categoria</th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<th scope="row"></th>
				<td></td>
				<td></td>
				<td></td>				
				<td></td>
				<td>
			</tr>
	</tbody>
</table>
