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
    <link rel="stylesheet" href="<c:url value="/assets/styles/styles.css"/>">
</head>
<body>

    <%@include file="../commons/header.jsp"%>

    <section class="section">
        <header class="section__header">
            <div class="container">
                <h2>Nova cotação</h2>
                <a href="<c:url value="/cotacoes"/>">Voltar</a>
            </div>
        </header>

        <div class="section__content">
            <div class="container">
                <form:form action="/cotacoes/novo" method="post" modelAttribute="novaCotacao" cssClass="form">
                    <div class="form__field">
                        <form:label path="idProduto">Produto:</form:label>
                        <form:select path="idProduto">
                            <form:option value="">-- Selecione um produto --</form:option>
                            <form:options items="${produtosDisponiveis}" itemValue="id" itemLabel="nome" />
                        </form:select>
                        <form:errors path="idProduto" />
                    </div>

                    <div class="form__field">
                        <form:label path="valor">Valor:</form:label>
                        <form:input path="valor" />
                        <form:errors path="valor" />
                    </div class="form__field">

                    <div class="form__field">
                        <form:label path="nomeCliente">Cliente:</form:label>
                        <form:input path="nomeCliente" />
                        <form:errors path="nomeCliente" />
                    </div class="form__field">

                    <div class="form__field">
                        <button type="submit" class="button">Registrar</button>
                        <button type="reset" class="button--secondary">Resetar</button>
                    </div>
                </form:form>
            </div>
        </div>
    </section>
</body>
</html>