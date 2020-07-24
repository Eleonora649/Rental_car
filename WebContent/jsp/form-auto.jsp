<div class="container">
	<form method="post">
		<div class="form-group">
			<label for="inputModello">Modello</label> <input type="text" required
				class="form-control" name="nome" id="inputModello">
		</div>

		<div class="form-group">
			<label for="inputTarga">Targa</label> <input type="text" required
				class="form-control" name="cognome" id="inputTarga">
		</div>

		<div class="form-group">
			<label for="inputCasaCostruttrice">Casa costruttrice</label> <input type="text" required 
			class="form-control" name="casaCostruttrice" id="inputCasaCostruttrice">
		</div>

		<div class="form-group">
			<label for="inputAnnoImm">Anno di immatricolazione</label> <input type="text" required 
			class="form-control" name="annoImm" id="inputAnnoImm">
		</div>

		<div class="form-row">
			<input type="radio" required id="" name="categoria" value=""> 
			<label for="">Suv</label>
			<input type="radio" required id="" name="categoria" value=""> 
			<label for="">Minivan</label>
			<input type="radio" required id="" name="categoria" value=""> 
			<label for="">Furgone</label>
		</div>

		<button type="submit" class="btn btn-primary">Registra auto</button>
	</form>
</div>