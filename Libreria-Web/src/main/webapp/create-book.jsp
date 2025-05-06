<%@page import="it.novello.models.Autore"%>
<%@page import="java.util.List"%>
<%@ include file="fragments/header.jsp" %>
<% 
@SuppressWarnings("unchecked")
List<Autore> authors = (List<Autore>)session.getAttribute("authors"); 
%>
	<h2>Nuovo libro</h2>
	<h3>Inserisci un nuovo libro da aggiungere alla tua libreria virtuale</h3>
	<form action="AddBook" method="post">
		<div class="riga">
			<div class="colonna"><input name="Titolo" type="text" placeholder="Titolo" required="required"></div>
			<div class="colonna"><input name="Sottotitolo" type="text" placeholder="Sottotitolo"></div>
		</div>
		<div class="riga">
			<div class="colonna">
				<select name="Autore" id="Autore" class="cptlz">
				<% for(Autore author : authors) { %>
					<option value="<% out.print(author.getId()); %>">
						<% out.print(author.getNome().toLowerCase()); %> <% out.print(author.getCognome().toLowerCase()); %>
					</option>
				<% } %>
				</select>
			</div>
		</div>
		<div class="riga">
			<div class="colonna"><input name="Editore" type="text" placeholder="Editore"></div>
		</div>
		<div class="riga">
			<div class="colonna"><input name="Anno" type="number" placeholder="Anno di pubblicazione"></div>
			<div class="colonna"><input name="Pagine" type="number" placeholder="Numero di pagine"></div>
		</div>
		<button type="submit" class="primario">Inserisci</button>
	</form>
</body>
</html>