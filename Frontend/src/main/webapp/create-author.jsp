<%@ include file="fragments/header.jsp" %>
	<h2>Nuovo Autore</h2>
	<h3>Inserisci un nuovo autore da aggiungere alla tua anagrafica</h3>
	<form action="AddAuthor" method="post">
		<div class="riga">
			<div class="colonna"><input name="Nome" type="text" placeholder="Nome" required="required"></div>
			<div class="colonna"><input name="Cognome" type="text" placeholder="Cognome"></div>
		</div>
		<div class="riga">
			<div class="colonna"><input name="Compleanno" type="date" placeholder="Data di nascita"></div>
		</div>
		<button type="submit" class="primario">Inserisci</button>
	</form>
</body>
</html>