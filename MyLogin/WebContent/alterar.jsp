<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<style >
INPUT.MeuInput2 {
     width: 120px;
     height: 20px;
     font-family: verdana;
     ybackground-color:white;
     font-style: inherit;
     font-size: large;	    
     border-color: black;
}
</style>

<style>
p{
 font: bolder;
 font-size: 20px;
}
</style>

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
					<p><td>ID:  </td></p>
					<td><input type="text"class="MeuInput2" name="id" id="id" value="${cliente.id}"/> </td>
				</tr>
				<tr>
				<tr>
					<td>Email:  </td>
					<td><input type="text" class="MeuInput2"name="email" id="email" value="${cliente.email}" /> </td>
				</tr>
				<tr>
					<td>Senha:</td>
					<td><input type="password"class="MeuInput2" name="senha" id="senha" value="${cliente.senha}" /></td>
				</tr>
				<tr>
					<td>CPF:</td>
					<td><input type="text"class="MeuInput2" name="cpf" id="cpf" value="${cliente.cpf}" /></td>
				</tr>
				<tr>
					<td>NOME:</td>
					<td><input type="text"class="MeuInput2" name="nome" id="nome" value="${cliente.nome}" /></td>
				</table>
				
				</tr>
				<tr>
					<td><input type="submit" class="MeuInput" value=" &#10003 SALVAR"  /></td>
					<td><input type="reset"  class="MeuInput" value="&#10008 LIMPAR" /></td>
				</tr>
			
			</c:forEach>
			
	</form>

</body>
</html>