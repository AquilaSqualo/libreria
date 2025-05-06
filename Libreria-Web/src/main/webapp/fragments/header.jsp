<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libreria</title>
<link rel="stylesheet" href="style/stylesheet.css">
<link rel="icon" type="image/x-icon" href="image/favicon.png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Borel&family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap" rel="stylesheet">
<script type="text/javascript">
	function ToggleMenu() {
		var menu = document.getElementById("menu");
		if(menu.style.display == "grid") {
			menu.style.display = "none";
		} else {
			menu.style.display = "grid";
		}
	}
</script>
</head>
<body>
	<nav class="navbar">
		<button class="secondario" type="button" onclick="ToggleMenu()">Menu</button>
		<a href="/Libreria-Web/AllBooks">Libreria</a>
	</nav>
	<div class="menu" id="menu">
		<button class="chiudi secondario" type="button" onclick="ToggleMenu()">X</button>
		<ul>
			<li><a href="/Libreria-Web/AllAuthors">Elenco degli autori</a></li>
			<li><a href="/Libreria-Web/AddBook">Inserisci un nuovo libro</a></li>
			<li><a href="/Libreria-Web/AddAuthor">Inserisci un nuovo autore</a></li>
		</ul>
	</div>