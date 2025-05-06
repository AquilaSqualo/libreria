<%@page import="java.util.List"%>
<%@page import="it.novello.models.Autore"%>
<%@page import="it.novello.models.Libro"%>
<%@ include file="fragments/header.jsp" %>
<% Libro book = (Libro)session.getAttribute("book"); %>
<% 
@SuppressWarnings("unchecked")
List<Autore> authors = (List<Autore>)session.getAttribute("authors"); 
%>
	<form action="EditBook?id=<% out.print(book.getId()); %>" method="post">
		<input name="IdLibro" type="hidden" value=<% out.print(book.getId()); %>>
		<div class="colonna">
			<label for="Titolo">Titolo</label>
			<input name="Titolo" id="Titolo" type="text" value="<% out.print(book.getTitle()); %>">
		</div>
		<div class="colonna">
			<label for="Sottotitolo">Sottotitolo</label>
			<input name="Sottotitolo" id="Sottotitolo" type="text" value="<% if(book.getSubTitle() != null && book.getSubTitle().trim().length() > 0) {out.print(book.getSubTitle());} %>">
		</div>
		<div class="colonna">
			<label for="Autore">Autore</label>
			<select name="Autore" id="Autore" class="cptlz">
			<% for(Autore author : authors) { %>
				<option value="<% out.print(author.getId()); %>" 
					<% if(author.getId() == book.getAuthor().getId()) { %> selected="selected" <% } %>>
					<% out.print(author.getNome().toLowerCase()); %> <% out.print(author.getCognome().toLowerCase()); %>
				</option>
			<% } %>
			</select>
		</div>
		<div class="colonna">
			<label for="Editore">Editore</label>
			<input name="Editore" id="Editore" type="text" value="<% out.print(book.getEditor()); %>">
		</div>
		<div class="colonna">
			<label for="Anno">Pubblicato il</label>
			<input name="Anno" id="Anno" type="number" value="<% out.print(book.getYear()); %>">
		</div>
		<div class="riga">
			<div class="colonna">
				<label for="Pagine">Numero pagine</label>
				<input name="Pagine" id="Pagine" type="number" value="<% out.print(book.getPages()); %>">
			</div>
			<div class="colonna">
				<label for="Segnalibro">Segnalibro</label>
				<input name="Segnalibro" id="Segnalibro" type="number" value="<% out.print(book.getBookmark()); %>">
			</div>
		</div>
		<div class="inlinea">
			<button class="primario" type="submit">Salva</button>
			<button class="secondario" type="button" onclick="location.href='BookDetails?id=<%out.print(book.getId());%>'">Annulla</button>
			<button class="secondario" type="button" onclick="location.href='DeleteBook?id=<%out.print(book.getId());%>'">Elimina</button>
		</div>
		</form>
</body>
</html>