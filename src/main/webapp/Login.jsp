<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<body>
	<form action="Autenticador" method="post">
	     Login: <input type="text"  	name="login" size=15 > 	<br><br>
	     Senha:	<input  type="password" name=senha	 size=15 ><br><br>	     
	     <input type='submit' value="Enviar">
	</form>	
<%
	String erro = (String) request.getAttribute("erro");
	if(erro!=null && !erro.trim().equals("")){
		out.print(erro);
	}
%>
	</body>
</html>
