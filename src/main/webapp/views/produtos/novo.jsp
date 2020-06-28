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
                <h1>Novo produto</h1>
                <a href="<c:url value="/produtos"/>">Voltar</a>
            </div>
        </header>
        <div class="section__content">
            <div class="container">
                <form:form action="/produtos/novo" method="post" modelAttribute="novoProduto" cssClass="form">
                    <div class="form__field">
                        <form:label path="nome">Nome:</form:label>
                        <form:input path="nome" />
                        <form:errors path="nome" />
                    </div>

                    <div class="form__field">
                        <form:label path="fornecedor">Fornecedor:</form:label>
                        <form:input path="fornecedor" />
                        <form:errors path="fornecedor" />
                    </div>

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