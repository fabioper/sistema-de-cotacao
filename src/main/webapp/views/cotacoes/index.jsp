<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sistema de Cotação</title>
</head>
<body>

    <h1>Cotações</h1>
    <a href="<c:url value="/cotacoes/novo"/>">Nova cotação</a>

    <c:choose>
        <c:when test="${!empty cotacoes}">
            <c:forEach var="cotacao" items="${cotacoes}">
                <div>
                    <h2>${cotacao.produto.nome}</h2>
                    <p>${cotacao.valor}</p>
                    <p>${cotacao.dataCotacao}</p>
                </div>
            </c:forEach>
        </c:when>

        <c:otherwise>
            <p>Nenhuma cotação adicionada</p>
        </c:otherwise>
    </c:choose>

</body>
</html>