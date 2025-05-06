<%@page import="java.util.List"%>
<%@page import="it.novello.models.Autore"%>
<%@page import="it.novello.models.Libro"%>
<%@ include file="fragments/header.jsp" %>
<% Libro book = (Libro)session.getAttribute("book"); %>
<form action="DeleteBook?id=<% out.print(book.getId()); %>" method="post">
	<input name="IdLibro" type="hidden" value=<% out.print(book.getId()); %>>
	<h2>Attenzione!</h2>
	<h3>Questa operazione è irreversibile.</h3>
	<div class="inlinea">
		<button class="primario" type="submit">Elimina</button>
		<button class="secondario" type="button" onclick="location.href='BookDetails?id=<%out.print(book.getId());%>'">Annulla</button>
	</div>
</form>
</body>
</html>