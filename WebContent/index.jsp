<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Empresas</title>
    <meta charset="UTF-8">
</head>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>
<c:if test="${not empty usuarioLogado}">
    Usuário logado: ${usuarioLogado.email}
</c:if>

<c:if test="${not empty usuarioLogado}">
<h1>Adicionar nova empresa:</h1>
<form action="novaEmpresa" method="post">
    Nome: <input type="text" name="nome"><br>
    <input type="submit" value="Enviar">
</form>
</c:if>

<c:if test="${empty usuarioLogado}">

<h1>Logar:</h1>

<form method="post" action="login">
    E-mail: <input type="email" name="email"><br>
    Senha: <input type="password" name="senha"><br>
    <input type="submit" value="Logar">
</form>
</c:if>

<c:if test="${not empty usuarioLogado}">
<form method="post" action="logout">
    <input type="submit" value="Logout">
</form>
</c:if>

</body>
</html>