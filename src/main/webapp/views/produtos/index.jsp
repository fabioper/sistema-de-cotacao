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

    <h1>Produtos</h1>
    <a href="<c:url value="/produtos/novo"/>">Novo produto</a>

    <c:choose>
        <c:when test="${!empty produtos}">
            <c:forEach var="produto" items="${produtos}">
                <div>
                    <h2>${produto.nome}</h2>
                    <p>${produto.fornecedor.nomeFornecedor}</p>
                </div>
            </c:forEach>
        </c:when>

        <c:otherwise>
            <p>Nenhum produto adicionada</p>
        </c:otherwise>
    </c:choose>

</body>
</html>