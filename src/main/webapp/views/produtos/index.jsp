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
    <link href="https://unpkg.com/vanilla-datatables@latest/dist/vanilla-dataTables.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<c:url value="/assets/styles/styles.css"/>">
</head>
<body>

    <%@include file="../commons/header.jsp"%>

    <section class="section">
        <header class="section__header">
            <div class="container">
                <h2 class="section__title">Produtos</h2>
                <a href="<c:url value="/produtos/novo"/>" class="button">Novo produto</a>
            </div>
        </header>

        <section class="section__content">
            <div class="container">
                <table id="table">
                    <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Fornecedor</th>
                        <th>Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${!empty produtos}">
                            <c:forEach var="produto" items="${produtos}">
                                <tr>
                                    <td>${produto.nome}</td>
                                    <td>${produto.fornecedor.nomeFornecedor}</td>
                                    <td>
                                        <a href="/produtos/${produto.id}/excluir">Excluir</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <p>Nenhuma cotação adicionada</p>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
            </div>
        </section>
    </section>

    <script src="https://unpkg.com/vanilla-datatables@latest/dist/vanilla-dataTables.min.js" type="text/javascript"></script>
    <script>
        const table = new DataTable("#table");
    </script>
</body>
</html>