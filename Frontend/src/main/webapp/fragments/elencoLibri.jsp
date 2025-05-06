<%@page import="it.novello.models.Libro"%>
<%@page import="java.util.List"%>
<%
@SuppressWarnings("unchecked")
List<Libro> books = (List<Libro>)(session.getAttribute("listBook"));
%>
<div class="elenco">
<% for(Libro book : books) { %>
	<div class="card" onclick="location.href='BookDetails?id=<%out.print(book.getId());%>'">
		<h4><% out.print(book.getTitle()); %></h4>
		<% if(book.getSubTitle() != null && book.getSubTitle().trim().length() > 0) { %><h5><% out.print(book.getSubTitle()); %></h5><% } %>
		<div class="cptlz"><% out.print(book.getAuthor().getNome().toLowerCase()); %> <% out.print(book.getAuthor().getCognome().toLowerCase()); %></div>
		<div><% out.print(book.getEditor()); %></div>
		<div><% out.print(book.getYear()); %></div>
		<% if(book.getPages() == book.getBookmark()) { %>
		<div class="letto">100%</div>
		<% } else {%>
		<div class="nonletto"><% if(book.getPages() != 0) { out.print((int)(((float)book.getBookmark() / (float)book.getPages())*100)); }; %>%</div>
		<% } %>
	</div>
<% } %>
</div>