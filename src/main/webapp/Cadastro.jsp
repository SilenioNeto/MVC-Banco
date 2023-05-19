<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
</head>
<body>
	<h3>Cadastro</h3>
	<form action="Cadastro" method="post">
		Nome: <input type="text" name="nome" size=15><br>
		Login: <input type="text" name="login" size=15><br>
		Email: <input type="email" name="email" size=15><br>
		Senha: <input type="password" name="senha1" size=15><br>
		Confirmar senha: <input type="password" name="senha2" size=15><br>
		<input type='submit' value="Cadastrar"><br><br>
	</form>
	<%
	String erro = (String) request.getAttribute("erro");
	if (erro != null && !erro.trim().equals("")) {
		out.print("ERRO: " + erro);
	}
	%>
</body>
</html>	