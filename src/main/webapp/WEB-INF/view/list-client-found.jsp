<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>CRM Gestion des Clients</title>
<!-- Ajout dossier CSS -->
	<link 	type="text/css" 
			rel="stylesheet" 
			href="${pageContext.request.contextPath}/ressources/css/style.css">
</head>
<body>
	

	<div id="wrapper">
		<div id="header">
		<h2>CRM -Gestionnaire des Clients</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
				
			<table>
				<tr>
					<th>Prenom</th>
					<th>Nom</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
			
			<!-- une boucle pour obtenir la liste des clients depuis le controlleur -->
				<c:forEach var="tempClients" items="${listClientFoundJSP}">
				
					<!-- lien de mise à jour dans la variable lienMiseAJour - id obtenu dans une boucle for -->
					<c:url var="lienMiseAJour" value="/clients/formulaireMAJClient">
						<c:param name="idClient" value="${tempClients.id}">
						</c:param>
					</c:url>
					<!-- lien de suppression dans une variable lienSuppression - id obtenu dans une boucle for -->
						<c:url var="lienSuppression" value="/clients/suppressionClient">
						<c:param name="idClient" value="${tempClients.id}">
						</c:param>
					</c:url>
				
					<tr>
						<td>${tempClients.prenom}</td>
						<td>${tempClients.nom}</td>
						<td>${tempClients.email}</td>
						<td><a href="${lienMiseAJour}">Mise à jour </a>
						|<a href="${lienSuppression}" onclick="if (!(confirm('Confirmer vous la suppression ?')))return false"> Suppression</a> </td>
					</tr>
				</c:forEach>

			</table>
</div>
<p>
			<a href="${pageContext.request.contextPath}/clients/liste">Retour
				vers la liste</a>
		</p>	
	</div>
</body>
</html>