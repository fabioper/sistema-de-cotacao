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

    <h1>Nova cotação</h1>
    <a href="<c:url value="/cotacoes"/>">Voltar</a>

    <form:form action="/cotacoes/novo" method="post" modelAttribute="novaCotacao">

        <div>
            <form:label path="idProduto">Produto:</form:label>
            <form:select path="idProduto">
                <form:option value="">-- Selecione um produto --</form:option>
                <form:options items="${produtosDisponiveis}" itemValue="id" itemLabel="nome" />
            </form:select>
            <form:errors path="idProduto" />
        </div>

        <div>
            <form:label path="">Valor:</form:label>
            <form:input path="valor" />
            <form:errors path="valor" />
        </div>

        <div>
            <button type="submit">Registrar</button>
            <button type="reset">Resetar</button>
        </div>
    </form:form>
</body>
</html>