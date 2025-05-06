<%@page import="it.novello.models.Autore"%>
<%@ include file="fragments/header.jsp" %>
<% Autore author = (Autore)session.getAttribute("author"); %>
<form action="DeleteAuthor?id=<% out.print(author.getId()); %>" method="post">
	<input name="IdAutore" type="hidden" value=<% out.print(author.getId()); %>>
	<h2>Attenzione!</h2>
	<h3>Questa operazione è irreversibile.</h3>
	<div class="inlinea">
		<button class="primario" type="submit">Elimina</button>
		<button class="secondario" type="button" onclick="location.href='EditAuthor?id=<%out.print(author.getId());%>'">Annulla</button>
	</div>
</form>
</body>
</html>