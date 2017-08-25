<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Clientes</title>
<style >
INPUT.MeuInput {
     width: 160px;
     height: 38px;
     font-family: verdana;
     background-color:green;
     font-style: inherit;
     font-size: large;
	 border:medium;	    
     border-color: black;
}
</style>

<style >
INPUT.MeuInput2 {
     width: 135px;
     height: 30px;
     font-family: verdana;
     background-color:white;
     font-style: inherit;
     font-size: large;	    
     border-color: black;
}
</style>

<style>

table.linhasAlternadas tr.even{
    background: #F0FFFF;
}
</style>
</head>
<body>
	<center>
		<h1>Lista de Clientes</h1>
		<tr>
				<form action="">
					<td><input type="button" class="MeuInput" align="left" value="&#8678 Voltar"
						onClick="history.go(-1)" /></td>
				</form>
			</tr>
		<form action="/MyLogin/listarClientesServlet" method="post">
			<c:choose>
				<c:when test="${not empty listaClientes}">
					<table border="3px" cellpadding="7px" cellspacing="0" ID="alter" >
						<tr >
							<td bgcolor="gren">Id</td>
							<td bgcolor="gren">Nome</td>
							<td bgcolor="gren">Cpf</td>
							<td bgcolor="gren">Email</td>
							<td bgcolor="gren">Senha</td>
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
		<table>
			<tr>
				<form action="/MyLogin/ExcluirUsuarioServlet" method="post">
					<td><input type="text" class="MeuInput2"  name="id" id="id"
						value="Digite aqui..." /> <input type="submit" class="MeuInput"
						value="&#10008 Excluir Usuario" /></td>
					<div class="alert alert-success">
					<h3>${mensagemExluido}</h3></div>
				</form>
			</tr>
			<tr>
				<form action="/MyLogin/ObterDadosServlet" method="get">
					<td><input type="text" class="MeuInput2"  name="iid" id="iid"
						value="Digite aqui..." /> <input type="submit" class="MeuInput" value="&#9998 ALTERAR" /></td>

				</form>
			</tr>
		</table>
	</center>
</body>
</html>