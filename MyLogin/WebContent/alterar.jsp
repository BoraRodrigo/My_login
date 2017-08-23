<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar </title>
</head>
<body>
<form action="/MyLogin/AlterarUsuarioServlet" method="post">
		<center>
			<h1>ALTERAR USUÁRIO</h1>
			<hr>
			<c:forEach var="cliente" items="${cliente}">
			<table>
				<tr>
					<td>ID:  </td>
					<td><input type="text" name="id" id="id" value="${cliente.id}"/> </td>
				</tr>
				<tr>
				<tr>
					<td>Email:  </td>
					<td><input type="text" name="email" id="email" value="${cliente.email}" /> </td>
				</tr>
				<tr>
					<td>Senha:</td>
					<td><input type="password" name="senha" id="senha" value="${cliente.senha}" /></td>
				</tr>
				<tr>
					<td>CPF:</td>
					<td><input type="text" name="cpf" id="cpf" value="${cliente.cpf}" /></td>
				</tr>
				<tr>
					<td>NOME:</td>
					<td><input type="text" name="nome" id="nome" value="${cliente.nome}" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="SALVAR ALTERAÇÃO" /></td>
					<td><input type="reset" value="Limpar" /></td>
				</tr>
			</table>
			</c:forEach>
			
	</form>

</body>
</html>