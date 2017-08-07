<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Empresas</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Resultado da busca:</h1>
<ul>
    <c:forEach var="empresa" items="${empresas}">
        <li>${empresa.id}: ${empresa.nome}</li>
    </c:forEach>
</ul>
</body>
</html>