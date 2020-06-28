<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <h1>Novo produto</h1>
    <a href="<c:url value="/produtos"/>">Voltar</a>

    <form:form action="/produtos/novo" method="post" modelAttribute="novoProduto">
        <div>
            <form:label path="nome">Nome:</form:label>
            <form:input path="nome" />
            <form:errors path="nome" />
        </div>

        <div>
            <form:label path="fornecedor">Fornecedor:</form:label>
            <form:input path="fornecedor" />
            <form:errors path="fornecedor" />
        </div>

        <div>
            <button type="submit">Registrar</button>
            <button type="reset">Resetar</button>
        </div>
    </form:form>

</body>
</html>