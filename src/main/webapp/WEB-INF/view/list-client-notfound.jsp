<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/ressources/css/style.css ">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/ressources/css/add-customer-style.css ">

<title>CRM -Gestionnaire des Clients - Sauvegarde client</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM -Gestionnaire des Clients</h2>
		</div>
		<div id="container">
			<h3>Recherche de client</h3>

		</div>


		<table>
			<tbody>
				<tr>
					<td>Client non trouvée</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<br>

		<div style=""></div>
		<p>
			<a href="${pageContext.request.contextPath}/clients/liste">Retour
				vers la liste</a>
		</p>
	</div>
</body>
</html>