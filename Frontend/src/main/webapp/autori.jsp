<%@page import="it.novello.controller.DateConversion"%>
<%@page import="it.novello.models.Autore"%>
<%@page import="java.util.List"%>
<%@ include file="fragments/header.jsp" %>
<% 
@SuppressWarnings("unchecked")
List<Autore> listAuthors = (List<Autore>)(session.getAttribute("authors"));
DateConversion dc = new DateConversion();
%>
	<div class="elenco">
		<% for(Autore author : listAuthors) { %>
		<div class="cardID">
			<h4><% out.print(author.getNome().toUpperCase()); %> <% out.print(author.getCognome().toUpperCase()); %></h4>
			<p><% if(author.getCompleanno() == null) {%> Data di nascita non impostata
			<%  } else out.print(dc.fromDateToString(author.getCompleanno())); %></p>
			<button type="button" class="icon" onclick="location.href='EditAuthor?id=<%out.print(author.getId());%>'"><img src="./image/edit-red.png" class="icon"></button>
		</div>
		<% } %>
	</div>
</body>
</html>