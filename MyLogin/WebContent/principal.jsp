<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
INPUT.MeuInput {
     width: 120px;
     height: 30px;
     font-family: verdana;
     background-color:green;
     font-style: inherit;
     font-size: large;
}
</style>
</head>
<body>
	<center>		
		<h1>Ol� ${cliente.nome}</h1>
		Seu email �:
		<c:out value="${cliente.email}" />
		<form action="">

			<input type="button" class="MeuInput" value="Voltar" onClick="history.go(-1)">
		</form>
	</center>
</body>
</html>