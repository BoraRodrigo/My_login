<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Clientes</title>
</head>
<body>
	<center>
	<h1>Lista de Clientes</h1>
	<for action="/MyLogin/listarClientesServlet" method="post"> <c:choose>
		<c:when test="${not empty listaClientes}">
			<table class="table table-striped">
				<tr>
					<td>id</td>
					<td>Nome</td>
					<td>Cpf</td>
					<td>Email</td>
					<td>Senha</td>
				</tr>
				<c:forEach var="cliente" items="${listaClientes}">
					<tr>
						<td>${cliente.id}</td>
						<td>${cliente.nome}</td>
						<td>${cliente.cpf}</td>
						<td>${cliente.email}</td>
						<td>${cliente.senha}</td>
					</tr>

				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<br>
			<div class="alert alert-info">Lista Vazia</div>
		</c:otherwise>
	</c:choose>
	</form>
	<form action="">
		<input type="button" value="Voltar" onClick="history.go(-1)">
	</form>
	</center>
</body>
</html>