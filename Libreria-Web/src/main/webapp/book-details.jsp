<%@page import="it.novello.models.Libro"%>
<%@ include file="fragments/header.jsp" %>
<% Libro book = (Libro)session.getAttribute("book"); %>
<form class="card">
	<div>
		<input name="IdLibro" type="hidden" value=<% out.print(book.getId()); %>>
		<h4><% out.print(book.getTitle()); %></h4>
		<h5><% if(book.getSubTitle() != null) out.print(book.getSubTitle()); %></h5>
		<p class="cptlz"><% out.print(book.getAuthor().getNome().toLowerCase()); %> <% out.print(book.getAuthor().getCognome().toLowerCase()); %></p>
		<p><% out.print(book.getEditor()); %></p>
		<p>Pubblicato il: <% out.print(book.getYear()); %></p>
		<p>Numero pagine: <% out.print(book.getPages()); %></p>
		<p>Segnalibro: <% out.print(book.getBookmark()); %></p>
	</div>
	<button type="button" class="icon" onclick="location.href='EditBook?id=<%out.print(book.getId());%>'"><img src="./image/edit-red.png" class="icon"></button>
</form>
</body>
</html>