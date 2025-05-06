<%@page import="it.novello.models.Autore"%>
<%@ include file="fragments/header.jsp" %>
<% Autore author = (Autore)session.getAttribute("author"); %>
	<input name="IdAutore" type="hidden" value=<% out.print(author.getId()); %>>
	<h1>Attenzione!</h1>
	<h2>L'autore che si vuole eliminare è collegato a dei libri. Per questo motivo non è possibile eliminarlo</h2>
	<div class="inlinea">
		<button class="primario" type="button" onclick="location.href='EditAuthor?id=<%out.print(author.getId());%>'">Torna indietro</button>
	</div>
</body>
</html>