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
                <h2 class="section__title">Cotações</h2>
                <a href="<c:url value="/cotacoes/novo"/>" class="button">Nova cotação</a>
            </div>
        </header>

        <div class="section__content">
            <div class="container">
                <table id="table">
                    <thead>
                    <tr>
                        <th>Produto</th>
                        <th>Valor</th>
                        <th>Data</th>
                        <th>Cliente</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${!empty cotacoes}">
                            <c:forEach var="cotacao" items="${cotacoes}">
                                <tr>
                                    <td>${cotacao.produto.nome}</td>
                                    <td>${cotacao.valor}</td>
                                    <td>${cotacao.dataCotacao}</td>
                                    <td>${cotacao.cliente.nomeCliente}</td>
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
        </div>
    </section>

    <script src="https://unpkg.com/vanilla-datatables@latest/dist/vanilla-dataTables.min.js" type="text/javascript"></script>
    <script>
        const table = new DataTable("#table");
    </script>
</body>
</html>