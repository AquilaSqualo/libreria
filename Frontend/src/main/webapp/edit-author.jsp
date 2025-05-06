<%@page import="it.novello.models.Autore"%>
<%@ include file="fragments/header.jsp" %>
<% Autore author = (Autore)session.getAttribute("author"); %>
	<form action="EditAuthor?id=<% out.print(author.getId()); %>" method="post">
		<input name="IdAutore" type="hidden" value=<% out.print(author.getId()); %>>
		<div class="riga">
			<div class="colonna">
				<label for="Nome">Nome</label>
				<input name="Nome" id="Nome" type="text" value="<% out.print(author.getNome()); %>">
			</div>
			<div class="colonna">
				<label for="Cognome">Cognome</label>
				<input name="Cognome" id="Cognome" type="text" value="<% out.print(author.getCognome()); %>">
			</div>
		</div>
		<div class="colonna">
			<label for="Compleanno">Data di nascita</label>
			<input name="Compleanno" id="Compleanno" type="date" value="<% out.print(author.getCompleanno()); %>">
		</div>
		<div class="inlinea">
			<button class="primario" type="submit">Salva</button>
			<button class="secondario" type="button" onclick="location.href='AllAuthors'">Annulla</button>
			<button class="secondario" type="button" onclick="location.href='DeleteAuthor?id=<%out.print(author.getId());%>'">Elimina</button>
		</div>
	</form>
</body>
</html>